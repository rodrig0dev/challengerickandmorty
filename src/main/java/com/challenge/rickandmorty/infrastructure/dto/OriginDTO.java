package com.challenge.rickandmorty.infrastructure.dto;

import java.io.Serializable;
import java.util.List;

public class OriginDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String url;
    private String dimension;
    private List<String> residents;

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public String getDimension() {
        return dimension;
    }

    public List<String> getResidents() {
        return residents;
    }


    public static final class Builder {
        private String name;
        private String url;
        private String dimension;
        private List<String> residents;

        private Builder() {
        }

        public static Builder anOriginDTO() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withDimension(String dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder withResidents(List<String> residents) {
            this.residents = residents;
            return this;
        }

        public OriginDTO build() {
            OriginDTO originDTO = new OriginDTO();
            originDTO.dimension = this.dimension;
            originDTO.name = this.name;
            originDTO.url = this.url;
            originDTO.residents = this.residents;
            return originDTO;
        }
    }
}
