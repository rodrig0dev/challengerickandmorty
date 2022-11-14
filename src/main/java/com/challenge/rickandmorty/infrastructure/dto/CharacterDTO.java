package com.challenge.rickandmorty.infrastructure.dto;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class CharacterDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    @JsonProperty("episode_count")
    private Integer episodeCount;
    @JsonProperty("origin")
    private OriginDTO origin;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getSpecies() {
        return species;
    }

    public String getType() {
        return type;
    }

    public Integer getEpisodeCount() {
        return episodeCount;
    }

    public OriginDTO getOrigin() {
        return origin;
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String status;
        private String species;
        private String type;
        private Integer episodeCount;
        private OriginDTO origin;

        private Builder() {
        }

        public static Builder aCharacterDTO() {
            return new Builder();
        }

        public Builder withId(Integer id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withStatus(String status) {
            this.status = status;
            return this;
        }

        public Builder withSpecies(String species) {
            this.species = species;
            return this;
        }

        public Builder withType(String type) {
            this.type = type;
            return this;
        }

        public Builder withEpisodeCount(Integer episodeCount) {
            this.episodeCount = episodeCount;
            return this;
        }

        public Builder withOrigin(OriginDTO origin) {
            this.origin = origin;
            return this;
        }

        public CharacterDTO build() {
            CharacterDTO characterDTO = new CharacterDTO();
            characterDTO.type = this.type;
            characterDTO.species = this.species;
            characterDTO.origin = this.origin;
            characterDTO.name = this.name;
            characterDTO.id = this.id;
            characterDTO.episodeCount = this.episodeCount;
            characterDTO.status = this.status;
            return characterDTO;
        }
    }
}
