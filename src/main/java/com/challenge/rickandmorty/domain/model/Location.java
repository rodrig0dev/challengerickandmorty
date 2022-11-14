package com.challenge.rickandmorty.domain.model;



import java.time.LocalDateTime;
import java.util.List;


public class Location {
    private Integer id;
    private String name;
    private String type;
    private String dimension;
    private List<String> residents;
    private String url;
    private LocalDateTime created;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getDimension() {
        return dimension;
    }

    public List<String> getResidents() {
        return residents;
    }

    public String getUrl() {
        return url;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", dimension='" + dimension + '\'' +
                ", residents=" + residents +
                ", url='" + url + '\'' +
                ", created=" + created +
                '}';
    }

    public static final class Builder {
        private Integer id;
        private String name;
        private String type;
        private String dimension;
        private List<String> residents;
        private String url;
        private LocalDateTime created;

        private Builder() {
        }

        public static Builder aLocation() {
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

        public Builder withType(String type) {
            this.type = type;
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

        public Builder withUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder withCreated(LocalDateTime created) {
            this.created = created;
            return this;
        }

        public Location build() {
            Location location = new Location();
            location.url = this.url;
            location.dimension = this.dimension;
            location.type = this.type;
            location.id = this.id;
            location.name = this.name;
            location.residents = this.residents;
            location.created = this.created;
            return location;
        }
    }
}
