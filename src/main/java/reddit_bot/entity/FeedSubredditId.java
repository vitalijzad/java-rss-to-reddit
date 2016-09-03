package reddit_bot.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FeedSubredditId  implements java.io.Serializable {

    @Column(name="feed_id", nullable=false)
    private int feedId;
    @Column(name="subreddit_id", nullable=false)
    private int subredditId;

    public FeedSubredditId() {
    }

    public FeedSubredditId(int feedId, int subredditId) {
        this.feedId = feedId;
        this.subredditId = subredditId;
    }




    public int getFeedId() {
        return this.feedId;
    }

    public void setFeedId(int feedId) {
        this.feedId = feedId;
    }



    public int getSubredditId() {
        return this.subredditId;
    }

    public void setSubredditId(int subredditId) {
        this.subredditId = subredditId;
    }


    public boolean equals(Object other) {
        if ( (this == other ) ) return true;
        if ( (other == null ) ) return false;
        if ( !(other instanceof FeedSubredditId) ) return false;
        FeedSubredditId castOther = ( FeedSubredditId ) other;

        return (this.getFeedId()==castOther.getFeedId())
                && (this.getSubredditId()==castOther.getSubredditId());
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + this.getFeedId();
        result = 37 * result + this.getSubredditId();
        return result;
    }


}


