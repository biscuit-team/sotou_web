package cn.sotou.sso.oauth.provider;

import org.codehaus.jackson.JsonNode;
import org.scribe.builder.ServiceBuilder;
import org.scribe.up.profile.JsonHelper;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;

import cn.sotou.sso.oauth.api.QQWeiBoApi20;

public class QQWeiboProvider extends BaseOAuth20Provider {

	@Override
	protected void internalInit() {
		service = new ServiceBuilder().provider(QQWeiBoApi20.class)
				.apiKey(key).apiSecret(secret).callback(callbackUrl).build();
	}

	@Override
	protected String getProfileUrl() {
		// TODO Auto-generated method stub
		return String
				.format("https://open.t.qq.com/api/user/info?format=json&oauth_consumer_key=%s&oauth_version=2.a",
						secret);
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		UserProfile userProfile = new UserProfile();
		JsonNode json = JsonHelper.getFirstNode(body);
		userProfile.setId(json.get("openid").getIntValue());
		return userProfile;
	}

}
