package io.mindspice.http;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import io.mindspice.enums.ChiaService;
import io.mindspice.enums.endpoints.Endpoint;
import io.mindspice.schemas.ApiResponse;
import io.mindspice.schemas.TypeRefs;
import io.mindspice.util.JsonUtils;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public abstract class SharedAPI {
    protected final RPCClient client;
    protected final String address;


    protected SharedAPI(RPCClient client, ChiaService chiaService) {
        this.client = client;
        this.address = client.getAddressFor(chiaService);
    }


    protected <T> ApiResponse<T> newResponse(JsonNode jsonNode, String dataField, Class<T> type,
            Endpoint endpoint) throws IOException {

        var success = jsonNode.get("success").asBoolean();
        Optional<T> data = success
                ? Optional.ofNullable(JsonUtils.readJson(jsonNode.get(dataField), type))
                : Optional.empty();

        return new ApiResponse<>(
                data,
                success,
                jsonNode.hasNonNull("error") ? jsonNode.get("error").asText() : "",
                address + endpoint.getPath()
        );
    }


    protected <T> ApiResponse<T> newResponse(JsonNode jsonNode, Class<T> type,
            Endpoint endpoint) throws IOException {

        var success = jsonNode.get("success").asBoolean();
        Optional<T> data = success
                ? Optional.ofNullable(JsonUtils.readJson(jsonNode, type))
                : Optional.empty();

        return new ApiResponse<>(
                data,
                success,
                jsonNode.hasNonNull("error") ? jsonNode.get("error").asText() : "",
                address + endpoint.getPath()
        );
    }


    protected <T> ApiResponse<List<T>> newResponseList(JsonNode jsonNode, String dataField,
            TypeReference<List<T>> typeRef, Endpoint endpoint) throws IOException {

        var success = jsonNode.get("success").asBoolean();
        Optional<List<T>> data;
        if (success) {
            var list = JsonUtils.readJson(jsonNode.get(dataField).traverse(), typeRef);
            data = Optional.of(Collections.unmodifiableList(list));
        } else {
            data = Optional.empty();
        }
        return new ApiResponse<>(
                data,
                success,
                jsonNode.hasNonNull("error") ? jsonNode.get("error").asText() : "",
                address + endpoint.getPath()
        );
    }


    protected <T,U> ApiResponse<Map<T,U>> newResponseMap(JsonNode jsonNode, String dataField,
            TypeReference<Map<T,U>> typeRef, Endpoint endpoint) throws IOException {

        var success = jsonNode.get("success").asBoolean();
        Optional<Map<T,U>> data;
        if (success) {
            var map = JsonUtils.readJson(jsonNode.get(dataField).traverse(), typeRef);
            data = Optional.of(Collections.unmodifiableMap(map));
        } else {
            data = Optional.empty();
        }
        return new ApiResponse<>(
                data,
                success,
                jsonNode.hasNonNull("error") ? jsonNode.get("error").asText() : "",
                address + endpoint.getPath()
        );
    }


    protected <T> ApiResponse<T> newResponse(T object, Endpoint endpoint) throws IOException {
        return new ApiResponse<>(
                Optional.of(object),
                true,
                "",
                address + endpoint.getPath()
        );
    }


    protected <T> ApiResponse<T> newFailedResponse(JsonNode jsonNode, Endpoint endpoint) {
        return new ApiResponse<>(
                Optional.empty(),
                false,
                jsonNode.hasNonNull("error") ? jsonNode.get("error").asText() : "",
                address + endpoint.getPath()
        );
    }
}