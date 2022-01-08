package lab1.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonRootName(value = "studio")
public class Studio implements Serializable {
    @JacksonXmlElementWrapper(useWrapping = false)
    private List<Group> group;

    public Studio() {

    }

    public Studio(ArrayList<Group> group) {
        this.group = group;
    }

    public List<Group> getGroup() {
        return group;
    }

    public void setGroup(List<Group> group) {
        this.group = group;
    }

    public static class Group {
        private String album;
        private String date;

        private String studioName;

        public Group() {
        }

        public Group(String album, String date, String studioName) {
            this.album = album;
            this.date = date;
            this.studioName = studioName;
        }

        public String getAlbum() {
            return album;
        }

        public void setAlbum(String album) {
            this.album = album;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getStudioName() {
            return studioName;
        }
        public void setStudioName(String studioName) {
            this.studioName = studioName;
        }

    }
}
