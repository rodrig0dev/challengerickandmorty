package com.challenge.rickandmorty.domain.model;

public class CharacterOrigin {
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

        public static Builder aCharacterOrigin() {
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

        public CharacterOrigin build() {
            CharacterOrigin characterOrigin = new CharacterOrigin();
            characterOrigin.url = this.url;
            characterOrigin.name = this.name;
            return characterOrigin;
        }
    }
}
