package cn.sotou.sso.oauth.provider;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.codehaus.jackson.JsonNode;
import org.scribe.builder.ServiceBuilder;
import org.scribe.up.profile.JsonHelper;
import org.scribe.up.profile.UserProfile;
import org.scribe.up.provider.BaseOAuth20Provider;

import cn.sotou.sso.oauth.api.QQApi20;

public class QQProvider extends BaseOAuth20Provider {

	private static final Pattern openIdPattern = Pattern
			.compile("\"openid\":\"([^\"]+)\"");

	@Override
	protected void internalInit() {
		service = new ServiceBuilder().provider(QQApi20.class).apiKey(key)
				.apiSecret(secret).callback(callbackUrl).build();
	}

	@Override
	protected String getProfileUrl() {
		// TODO Auto-generated method stub
		return "https://graph.qq.com/oauth2.0/me";
	}

	@Override
	protected UserProfile extractUserProfile(String body) {
		UserProfile userProfile = new UserProfile();
		Matcher m = openIdPattern.matcher(body);
		if (m.find()) {
			userProfile.setId(m.group(1));
		}
		return userProfile;
	}

}
