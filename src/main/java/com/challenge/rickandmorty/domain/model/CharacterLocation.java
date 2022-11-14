package com.challenge.rickandmorty.domain.model;

public class CharacterLocation {

    private String name;
    private String url;

    public String getName() {
        return name;
    }
    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                '}';
    }


    public static final class Builder {
        private String name;
        private String url;

        private Builder() {
        }

        public static Builder aCharacterLocation() {
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

        public CharacterLocation build() {
            CharacterLocation characterLocation = new CharacterLocation();
            characterLocation.name = this.name;
            characterLocation.url = this.url;
            return characterLocation;
        }
    }
}
