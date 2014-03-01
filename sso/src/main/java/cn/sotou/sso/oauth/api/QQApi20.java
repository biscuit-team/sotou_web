package cn.sotou.sso.oauth.api;

import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
import org.scribe.utils.OAuthEncoder;

public class QQApi20 extends DefaultApi20 {

	private static final String AUTHORIZE_URL = "https://graph.qq.com/oauth2.0/authorize?"
			+ "client_id=%s&response_type=code&redirect_uri=%s";

	@Override
	public String getAccessTokenEndpoint() {
		return String.format("https://graph.qq.com/oauth2.0/token?grant_type=authorization_code");
	}

	@Override
	public String getAuthorizationUrl(OAuthConfig config) {
		return String.format(AUTHORIZE_URL, config.getApiKey(),
				OAuthEncoder.encode(config.getCallback()));
	}
}
