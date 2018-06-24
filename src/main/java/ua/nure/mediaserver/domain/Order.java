package ua.nure.mediaserver.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;

import java.util.Date;
import java.util.Set;

public class Order {

    @Id
    @JsonIgnore
    private ObjectId _id;
    @JsonIgnore
    private ObjectId creatorId;
    private String title;
    private boolean isPaid;
    private boolean isPrivate;
    private String description;
    private int photoCount;
    private int videoCount;
    private Set<String> hashtags;
    private Set<String> categories;
    private int likes;
    private int dislikes;
    private ua.nure.mediaserver.domain.Point location;
    private Date creationDate;
    private Date deadline;
    private float money;
    private String fullName;


    public Order() {

    }

    public ObjectId get_id() {
        return _id;
    }

    public ObjectId getCreatorId() {
        return creatorId;
    }

    public String getTitle() {
        return title;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public String getDescription() {
        return description;
    }

    public int getPhotoCount() {
        return photoCount;
    }

    public int getVideoCount() {
        return videoCount;
    }

    public Set<String> getHashtags() {
        return hashtags;
    }

    public Set<String> getCategories() {
        return categories;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public ua.nure.mediaserver.domain.Point getLocation() {
        return location;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public float getMoney() {
        return money;
    }

    public String getFullName() {
        return fullName;
    }

    public static Builder builder (){
        return new Order().new Builder();
    }

    public class Builder {

        private Builder(){

        }

        public Builder set_id (ObjectId _id) {
            Order.this._id = _id;
            return this;
        }

        public Builder setCreatorId(ObjectId creatorId) {
            Order.this.creatorId = creatorId;
            return this;
        }

        public Builder setTitle(String title) {
            Order.this.title = title;
            return this;
        }


        public Builder setFullname(String fullname) {
            Order.this.fullName = fullname;
            return this;
        }

        public Builder setPaid(boolean paid) {
            Order.this.isPaid = paid;
            return this;
        }

        public Builder setPrivate(boolean aPrivate) {
            Order.this.isPrivate = aPrivate;
            return this;
        }

        public Builder setDescription(String description) {
            Order.this.description = description;
            return this;
        }

        public Builder setPhotoCount(int photoCount) {
            Order.this.photoCount = photoCount;
            return this;
        }

        public Builder setVideoCount(int videoCount) {
            Order.this.videoCount = videoCount;
            return this;
        }

        public Builder setHashtags(Set<String> hashtags) {
            Order.this.hashtags = hashtags;
            return this;
        }

        public Builder setCategories(Set<String> categories) {
            Order.this.categories = categories;
            return this;
        }

        public Builder setLikes(int likes) {
            Order.this.likes = likes;
            return this;
        }

        public Builder setDislikes(int dislikes) {
            Order.this.dislikes = dislikes;
            return this;
        }

        public Builder setLocation(ua.nure.mediaserver.domain.Point location) {
            Order.this.location = location;
            return this;
        }

        public Builder setCreationDate(Date creationDate) {
            Order.this.creationDate = creationDate;
            return this;
        }

        public Builder setDeadline(Date deadline) {
            Order.this.deadline = deadline;
            return this;
        }

        public Builder setMoney(float money) {
            Order.this.money = money;
            return this;
        }

        public Order build(){
            return Order.this;
        }
    }

    @Override
    public String toString() {
        return "Order{" +
                "_id=" + _id +
                ", creatorId=" + creatorId +
                ", title='" + title + '\'' +
                ", isPaid=" + isPaid +
                ", isPrivate=" + isPrivate +
                ", description='" + description + '\'' +
                ", photoCount=" + photoCount +
                ", videoCount=" + videoCount +
                ", hashtags=" + hashtags +
                ", categories=" + categories +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", location=" + location +
                ", creationDate=" + creationDate +
                ", deadline=" + deadline +
                ", money=" + money +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
