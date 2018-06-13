package ua.nure.mediaserver.domain;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;

import java.util.Date;
import java.util.Set;

public class Order {

    @Id
    private ObjectId _id;
    private ObjectId creatorId;
    private boolean isPaid;
    private boolean isPrivate;
    private String description;
    private int photoCount;
    private int videoCount;
    private Set<String> hashtags;
    private Set<String> categories;
    private int likes;
    private int dislikes;
    private Point location;
    private Date creationDate;
    private Date deadline;
    private float money;


    public Order() {

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

        public Builder setLocation(Point location) {
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

}
