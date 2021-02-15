package cj.netos.fission;

import cj.netos.fission.model.Attachment;
import cj.netos.fission.model.LimitArea;
import cj.netos.fission.model.LimitTag;
import cj.netos.fission.model.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> listAllTag();

    void add(Tag tag);

    boolean exists(String tagId);

    void addPropertyTag(String principal, String tagId);

    List<Tag> listMyPropertyTag(String principal);

    void removePropertyTag(String principal, String tagId);

    Tag getTag(String tagId);

    void addLimitTag(LimitTag tag);

    void removeLimitTag(String principal, String direct, String tagId);

    List<Tag> listLimitTag(String principal, String direct);

    void setLimitArea(LimitArea area);

    void removeLimitArea(String principal, String direct);

    LimitArea getLimitArea(String principal, String direct);

    void setAttachment(Attachment attachment);

    void emptyAttachment(String principal);

    Attachment getAttachment(String principal);

    void setAdvert(String principal, String note);


}
