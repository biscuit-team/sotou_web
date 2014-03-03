package cn.sotou.sso.oauth.provider;

import java.util.concurrent.TimeUnit;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.node.ArrayNode;
import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.up.profile.JsonHelper;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;
import org.scribe.up.provider.impl.GoogleProvider;
import org.scribe.up.provider.impl.WordPressProvider;

import cn.sotou.sso.oauth.api.SinaWeiboApi20;

public class SinaWeiboProvider extends BaseOAuth20Provider {

	@Override
	protected void internalInit() {
		if (scope != null) {
			service = new ServiceBuilder().provider(SinaWeiboApi20.class)
					.apiKey(key).apiSecret(secret).callback(callbackUrl)
					.scope(scope).build();
		} else {
			service = new ServiceBuilder().provider(SinaWeiboApi20.class)
					.apiKey(key).apiSecret(secret).callback(callbackUrl)
					.build();
		}
		// String[] names = new String[] { "uid", "username" };
		// for (String name : names) {
		// mainAttributes.put(name, null);
		// }

	}
	
	/**
     * Make a request to get the data of the authenticated user for this provider.
     * 
     * @param accessToken
     * @param dataUrl
     * @return the user data response
     */
    protected String sendRequestForData(Token accessToken, String dataUrl) {
        logger.debug("accessToken : {} / dataUrl : {}", accessToken, dataUrl);
        long t0 = System.currentTimeMillis();
        OAuthRequest request = new OAuthRequest(Verb.POST, dataUrl);
        if (connectTimeout != 0) {
            request.setConnectTimeout(connectTimeout, TimeUnit.MILLISECONDS);
        }
        if (readTimeout != 0) {
            request.setReadTimeout(readTimeout, TimeUnit.MILLISECONDS);
        }
        service.signRequest(accessToken, request);

        Response response = request.send();
        int code = response.getCode();
        String body = response.getBody();
        long t1 = System.currentTimeMillis();
        logger.debug("Request took : " + (t1 - t0) + " ms for : " + dataUrl);
        logger.debug("response code : {} / response body : {}", code, body);
        if (code != 200) {
            logger.error("Failed to get user data, code : " + code + " / body : " + body);
            return null;
        }
        return body;
    }

	@Override
	protected String getProfileUrl() {
		// return "https://api.weibo.com/2/statuses/user_timeline.json";
		return "https://api.weibo.com/oauth2/get_token_info";
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		UserProfile userProfile = new UserProfile();
		JsonNode json = JsonHelper.getFirstNode(body);

		userProfile.setId(json.get("uid").getIntValue());

		return userProfile;
	}

}
