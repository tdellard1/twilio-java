/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.updater.api.v2010;

import com.twilio.sdk.client.TwilioRestClient;
import com.twilio.sdk.exception.ApiConnectionException;
import com.twilio.sdk.exception.ApiException;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resource.RestException;
import com.twilio.sdk.resource.api.v2010.Account;
import com.twilio.sdk.updater.Updater;

public class AccountUpdater extends Updater<Account> {
    private String sid;
    private String friendlyName;
    private Account.Status status;

    /**
     * Construct a new AccountUpdater.
     */
    public AccountUpdater() {
    }

    /**
     * Construct a new AccountUpdater.
     * 
     * @param sid The sid
     */
    public AccountUpdater(final String sid) {
        this.sid = sid;
    }

    /**
     * Update the human-readable description of this Account.
     * 
     * @param friendlyName FriendlyName to update
     * @return this
     */
    public AccountUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Alter the status of this account with a given Status.
     * 
     * @param status Status to update the Account with
     * @return this
     */
    public AccountUpdater setStatus(final Account.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Account
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Account execute(final TwilioRestClient client) {
        this.sid = this.sid == null ? client.getAccountSid() : this.sid;
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.API,
            "/2010-04-01/Accounts/" + this.sid + ".json",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Account update failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
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
        
        return Account.fromJson(response.getStream(), client.getObjectMapper());
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
        
        if (status != null) {
            request.addPostParam("Status", status.toString());
        }
    }
}