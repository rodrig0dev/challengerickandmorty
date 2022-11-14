package com.challenge.rickandmorty.domain.model;


import java.time.LocalDateTime;
import java.util.List;


public class Character {
    private Integer id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private CharacterOrigin origin;
    private CharacterLocation location;
    private String image;
    private List<String> episode;
    private String url;
    private LocalDateTime created;

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

    public String getGender() {
        return gender;
    }

    public CharacterOrigin getOrigin() {
        return origin;
    }

    public CharacterLocation getLocation() {
        return location;
    }

    public String getImage() {
        return image;
    }

    public List<String> getEpisode() {
        return episode;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getCreated() {
        return created;
    }



    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", species='" + species + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", origin=" + origin +
                ", location=" + location +
                ", image='" + image + '\'' +
                ", episode=" + episode +
                ", url='" + url + '\'' +
                ", created=" + created +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String status;
        private String species;
        private String type;
        private String gender;
        private CharacterOrigin origin;
        private CharacterLocation location;
        private String image;
        private List<String> episode;
        private String url;
        private LocalDateTime created;

        private Builder() {
        }

        public static Builder aCharacter() {
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

        public Builder withGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder withOrigin(CharacterOrigin origin) {
            this.origin = origin;
            return this;
        }

        public Builder withLocation(CharacterLocation location) {
            this.location = location;
            return this;
        }

        public Builder withImage(String image) {
            this.image = image;
            return this;
        }

        public Builder withEpisode(List<String> episode) {
            this.episode = episode;
            return this;
        }

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Character build() {
            Character character = new Character();
            character.id = this.id;
            character.url = this.url;
            character.episode = this.episode;
            character.created = this.created;
            character.gender = this.gender;
            character.species = this.species;
            character.image = this.image;
            character.type = this.type;
            character.name = this.name;
            character.origin = this.origin;
            character.location = this.location;
            character.status = this.status;
            return character;
        }
    }
}
