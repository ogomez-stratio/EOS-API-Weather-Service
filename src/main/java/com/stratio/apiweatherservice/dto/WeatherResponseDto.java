package com.stratio.apiweatherservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

/**
 * Dto class for yahoo weather query response
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WeatherResponseDto {

    private QueryProp query;

    @Data
    @Builder
    public static class QueryProp {

        private int count;
        private Date created;
        private String lang;
        private ResultsDto results;
    }

    @Data
    @Builder
    public static class ResultsDto {

        private ChannelDto channel;

        @Data
        @Builder
        public static class ChannelDto {

            private UnitsDto units;
            private String title;
            private String link;
            private String description;
            private String language;
            private String lastBuildDate;
            private String ttl;
            private LocationDto location;
            private WindDto wind;
            private AtmosDto atmosphere;
            private ImageDto image;
            private ItemDto item;
        }

    }



    @Data
    @Builder
    public static class UnitsDto {

        private String distance;
        private String pressure;
        private String speed;
        private String temperature;

    }

    @Data
    @Builder
    public static class LocationDto {
        private String city;
        private String country;
        private String region;
    }

    @Data
    @Builder
    public static class WindDto {
        private String chill;
        private String direction;
        private String speed;
    }

    @Data
    @Builder
    public static class AtmosDto {
        private String humidity;
        private String pressure;
        private String rising;
        private String visibility;

    }

    @Data
    @Builder
    public static class ImageDto {
        private String title;
        private String width;
        private String height;
        private String link;
        private String url;
    }

    @Data
    @Builder
    public static class ItemDto {
        private String title;
        private String lat;
        @JsonProperty("long")
        private String longitude;
        private String link;
        private String pubDate;
        private ConditionDto condition;
        private List<ForecastDto> forecast;
    }

    @Data
    @Builder
    public static class ConditionDto {
        private String code;
        private String date;
        private String temp;
        private String text;
    }


    @Data
    @Builder
    public static class ForecastDto {
        private String code;
        private String date;
        private String day;
        private String high;
        private String low;
        private String text;
    }
}
