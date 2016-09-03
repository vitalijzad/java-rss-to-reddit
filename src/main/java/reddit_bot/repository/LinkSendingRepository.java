package reddit_bot.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import reddit_bot.entity.LinkSending;
import reddit_bot.entity.Subreddit;

import java.util.Date;
import java.util.Set;

public interface LinkSendingRepository extends CrudRepository<LinkSending, Long> {

    @Query("select count(1) from LinkSending ls where ls.subreddit = :subreddit and sendingDate >= :sinceWhen")
    int linksSentAfter(
            @Param("subreddit") Subreddit subreddit,
            @Param("sinceWhen") Date sinceWhen);

    @Query("select distinct l.feed.id from LinkSending ls join ls.link l where ls.subreddit = :subreddit and ls.sendingDate >= :sinceWhen")
    Set<Long> feedsSentAfter(
            @Param("subreddit") Subreddit subreddit,
            @Param("sinceWhen") Date sinceWhen);
}
