/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /
 */

package com.twilio.rest.preview.hostedNumbers;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

/**
 * PLEASE NOTE that this class contains preview products that are subject to
 * change. Use them with caution. If you currently do not have developer preview
 * access, please contact help@twilio.com.
 */
public class AuthorizationDocumentUpdater extends Updater<AuthorizationDocument> {
    private final String pathSid;
    private List<String> hostedNumberOrderSids;
    private String addressSid;
    private String email;
    private List<String> ccEmails;
    private AuthorizationDocument.Status status;

    /**
     * Construct a new AuthorizationDocumentUpdater.
     * 
     * @param pathSid The sid
     */
    public AuthorizationDocumentUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * A list of HostedNumberOrder sids that this AuthorizationDocument will
     * authorize for hosting phone number capabilities on Twilio's platform..
     * 
     * @param hostedNumberOrderSids A list of HostedNumberOrder sids.
     * @return this
     */
    public AuthorizationDocumentUpdater setHostedNumberOrderSids(final List<String> hostedNumberOrderSids) {
        this.hostedNumberOrderSids = hostedNumberOrderSids;
        return this;
    }

    /**
     * A list of HostedNumberOrder sids that this AuthorizationDocument will
     * authorize for hosting phone number capabilities on Twilio's platform..
     * 
     * @param hostedNumberOrderSids A list of HostedNumberOrder sids.
     * @return this
     */
    public AuthorizationDocumentUpdater setHostedNumberOrderSids(final String hostedNumberOrderSids) {
        return setHostedNumberOrderSids(Promoter.listOfOne(hostedNumberOrderSids));
    }

    /**
     * A 34 character string that uniquely identifies the Address resource that is
     * associated with this AuthorizationDocument..
     * 
     * @param addressSid Address sid.
     * @return this
     */
    public AuthorizationDocumentUpdater setAddressSid(final String addressSid) {
        this.addressSid = addressSid;
        return this;
    }

    /**
     * Email that this AuthorizationDocument will be sent to for signing..
     * 
     * @param email Email.
     * @return this
     */
    public AuthorizationDocumentUpdater setEmail(final String email) {
        this.email = email;
        return this;
    }

    /**
     * A list of emails that this AuthorizationDocument will be carbon copied to..
     * 
     * @param ccEmails A list of emails.
     * @return this
     */
    public AuthorizationDocumentUpdater setCcEmails(final List<String> ccEmails) {
        this.ccEmails = ccEmails;
        return this;
    }

    /**
     * A list of emails that this AuthorizationDocument will be carbon copied to..
     * 
     * @param ccEmails A list of emails.
     * @return this
     */
    public AuthorizationDocumentUpdater setCcEmails(final String ccEmails) {
        return setCcEmails(Promoter.listOfOne(ccEmails));
    }

    /**
     * The Status of this AuthorizationDocument. User can only update this to
     * `opened` when AuthorizationDocument is in `signing`, or `signing` when
     * AuthorizationDocument is in `opened`..
     * 
     * @param status The Status of this AuthorizationDocument.
     * @return this
     */
    public AuthorizationDocumentUpdater setStatus(final AuthorizationDocument.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated AuthorizationDocument
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AuthorizationDocument update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.PREVIEW.toString(),
            "/HostedNumbers/AuthorizationDocuments/" + this.pathSid + "",
            client.getRegion()
        );

        addPostParams(request);
        Response response = client.request(request);

        if (response == null) {
            throw new ApiConnectionException("AuthorizationDocument update failed: Unable to connect to server");
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

        return AuthorizationDocument.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (hostedNumberOrderSids != null) {
            for (String prop : hostedNumberOrderSids) {
                request.addPostParam("HostedNumberOrderSids", prop);
            }
        }

        if (addressSid != null) {
            request.addPostParam("AddressSid", addressSid);
        }

        if (email != null) {
            request.addPostParam("Email", email);
        }

        if (ccEmails != null) {
            for (String prop : ccEmails) {
                request.addPostParam("CcEmails", prop);
            }
        }

        if (status != null) {
            request.addPostParam("Status", status.toString());
        }
    }
}