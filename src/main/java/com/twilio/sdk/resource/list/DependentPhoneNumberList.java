package com.twilio.sdk.resource.list;

import com.twilio.sdk.TwilioRestClient;
import com.twilio.sdk.resource.ListResource;
import com.twilio.sdk.resource.instance.DependentPhoneNumber;

import java.util.Map;

// TODO: Auto-generated Javadoc
/**
 * The Class DependentPhoneNumberList.
 *
 *  For more information see <a href="https://www.twilio.com/docs/api/rest/address">https://www.twilio.com/docs/api/rest/address</a>
 */
public class DependentPhoneNumberList extends ListResource<DependentPhoneNumber> {

	private String addressSid;

	/**
	 * Instantiates a new dependent phone number list.
	 *
	 * @param client the client
	 */
	public DependentPhoneNumberList(TwilioRestClient client) {
		super(client);
	}

	public DependentPhoneNumberList(TwilioRestClient client, String addressSid) {
		super(client);
		this.addressSid = addressSid;
	}

	/**
	 * Instantiates a new dependent phone number list.
	 *
	 * @param client the client
	 * @param filters the filters
	 */
	public DependentPhoneNumberList(TwilioRestClient client, Map<String, String> filters) {
		super(client, filters);
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.Resource#getResourceLocation()
	 */
	@Override
	protected String getResourceLocation() {
		return "/" + TwilioRestClient.DEFAULT_VERSION + "/Accounts/"
				+ this.getRequestAccountSid() + "/Conferences.json";
	}

	/* (non-Javadoc)
	 * @see com.twilio.sdk.resource.ListResource#getListKey()
	 */
	@Override
	protected String getListKey() {
		return "dependent_phone_numbers";
	}

	/* (non-Javadoc)
     * @see com.twilio.sdk.resource.ListResource#makeNew(com.twilio.sdk.TwilioRestClient, java.util.Map)
     */
	@Override
	protected DependentPhoneNumber makeNew(TwilioRestClient client, Map<String, Object> properties) {
		return new DependentPhoneNumber(client, properties);
	}

}
