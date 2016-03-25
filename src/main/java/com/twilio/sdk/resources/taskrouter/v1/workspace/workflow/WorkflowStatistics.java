/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.sdk.resources.taskrouter.v1.workspace.workflow;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.sdk.clients.TwilioRestClient;
import com.twilio.sdk.exceptions.ApiConnectionException;
import com.twilio.sdk.exceptions.ApiException;
import com.twilio.sdk.fetchers.taskrouter.v1.workspace.workflow.WorkflowStatisticsFetcher;
import com.twilio.sdk.http.HttpMethod;
import com.twilio.sdk.http.Request;
import com.twilio.sdk.http.Response;
import com.twilio.sdk.resources.Resource;
import com.twilio.sdk.resources.RestException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkflowStatistics extends Resource {
    private static final long serialVersionUID = 164789370388563L;

    /**
     * Create a WorkflowStatisticsFetcher to execute fetch.
     * 
     * @param workspaceSid The workspace_sid
     * @param workflowSid The workflow_sid
     * @return WorkflowStatisticsFetcher capable of executing the fetch
     */
    public static WorkflowStatisticsFetcher fetch(final String workspaceSid, 
                                                  final String workflowSid) {
        return new WorkflowStatisticsFetcher(workspaceSid, workflowSid);
    }

    /**
     * Converts a JSON String into a WorkflowStatistics object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return WorkflowStatistics object represented by the provided JSON
     */
    public static WorkflowStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkflowStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a WorkflowStatistics object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return WorkflowStatistics object represented by the provided JSON
     */
    public static WorkflowStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, WorkflowStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final JsonNode cumulative;
    private final JsonNode realtime;
    private final String workflowSid;
    private final String workspaceSid;

    @JsonCreator
    private WorkflowStatistics(@JsonProperty("account_sid")
                               final String accountSid, 
                               @JsonProperty("cumulative")
                               final JsonNode cumulative, 
                               @JsonProperty("realtime")
                               final JsonNode realtime, 
                               @JsonProperty("workflow_sid")
                               final String workflowSid, 
                               @JsonProperty("workspace_sid")
                               final String workspaceSid) {
        this.accountSid = accountSid;
        this.cumulative = cumulative;
        this.realtime = realtime;
        this.workflowSid = workflowSid;
        this.workspaceSid = workspaceSid;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The cumulative.
     * 
     * @return The cumulative
     */
    public final JsonNode getCumulative() {
        return this.cumulative;
    }

    /**
     * Returns The The realtime.
     * 
     * @return The realtime
     */
    public final JsonNode getRealtime() {
        return this.realtime;
    }

    /**
     * Returns The The workflow_sid.
     * 
     * @return The workflow_sid
     */
    public final String getWorkflowSid() {
        return this.workflowSid;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        WorkflowStatistics other = (WorkflowStatistics) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(cumulative, other.cumulative) && 
               Objects.equals(realtime, other.realtime) && 
               Objects.equals(workflowSid, other.workflowSid) && 
               Objects.equals(workspaceSid, other.workspaceSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            cumulative,
                            realtime,
                            workflowSid,
                            workspaceSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("cumulative", cumulative)
                          .add("realtime", realtime)
                          .add("workflowSid", workflowSid)
                          .add("workspaceSid", workspaceSid)
                          .toString();
    }
}