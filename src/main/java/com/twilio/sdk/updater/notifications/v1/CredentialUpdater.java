/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.updater.notifications.v1;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.notifications.v1.Credential;
import com.twilio.sdk.updater.Updater;

public class CredentialUpdater extends Updater<Credential> {
    private final String sid;
    private final String friendlyName;
    private final Credential.PushService type;
    private String certificate;
    private String privateKey;
    private Boolean sandbox;
    private String apiKey;

    /**
     * Construct a new CredentialUpdater.
     * 
     * @param sid The sid
     * @param friendlyName The friendly_name
     * @param type The type
     */
    public CredentialUpdater(final String sid, 
                             final String friendlyName, 
                             final Credential.PushService type) {
        this.sid = sid;
        this.friendlyName = friendlyName;
        this.type = type;
    }

    /**
     * The certificate.
     * 
     * @param certificate The certificate
     * @return this
     */
    public CredentialUpdater setCertificate(final String certificate) {
        this.certificate = certificate;
        return this;
    }

    /**
     * The private_key.
     * 
     * @param privateKey The private_key
     * @return this
     */
    public CredentialUpdater setPrivateKey(final String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    /**
     * The sandbox.
     * 
     * @param sandbox The sandbox
     * @return this
     */
    public CredentialUpdater setSandbox(final Boolean sandbox) {
        this.sandbox = sandbox;
        return this;
    }

    /**
     * The api_key.
     * 
     * @param apiKey The api_key
     * @return this
     */
    public CredentialUpdater setApiKey(final String apiKey) {
        this.apiKey = apiKey;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Credential
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Credential execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.NOTIFICATIONS,
            "/v1/Credentials/" + this.sid + "",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Credential update failed: Unable to connect to server");
        } else if (response.getStatusCode() != TwilioRestClient.HTTP_STATUS_CODE_OK) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return Credential.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (type != null) {
            request.addPostParam("Type", type.toString());
        }
        
        if (certificate != null) {
            request.addPostParam("Certificate", certificate);
        }
        
        if (privateKey != null) {
            request.addPostParam("PrivateKey", privateKey);
        }
        
        if (sandbox != null) {
            request.addPostParam("Sandbox", sandbox.toString());
        }
        
        if (apiKey != null) {
            request.addPostParam("ApiKey", apiKey);
        }
    }
}