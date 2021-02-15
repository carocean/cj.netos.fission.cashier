package cj.netos.fission.service;

import cj.lns.chip.sos.cube.framework.IDocument;
import cj.lns.chip.sos.cube.framework.IQuery;
import cj.lns.chip.sos.cube.framework.TupleDocument;
import cj.netos.fission.AbstractService;
import cj.netos.fission.ITagService;
import cj.netos.fission.model.Attachment;
import cj.netos.fission.model.LimitArea;
import cj.netos.fission.model.LimitTag;
import cj.netos.fission.model.Tag;
import cj.studio.ecm.annotation.CjService;
import cj.ultimate.gson2.com.google.gson.Gson;
import org.bson.Document;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@CjService(name = "tagService")
public class TagService extends AbstractService implements ITagService {
    final static String _COL = "fission.mf.tags";
    final static String _COL_TAG_PROP = "fission.mf.tags.properties";
    final static String _COL_TAG_LIMIT = "fission.mf.tags.limits";
    final static String _COL_AREA_LIMIT = "fission.mf.tags.areas";
    final static String _COL_ATTACH = "fission.mf.attachments";

    @Override
    public List<Tag> listAllTag() {
        String cjql = String.format("select {'tuple':'*'}.sort({'tuple.sort':1}) from tuple %s %s where {}", _COL, Tag.class.getName());
        IQuery<Tag> query = getHome().createQuery(cjql);
        List<IDocument<Tag>> documents = query.getResultList();
        List<Tag> tags = new ArrayList<>();
        for (IDocument<Tag> document : documents) {
            tags.add(document.tuple());
        }
        return tags;
    }

    @Override
    public void add(Tag tag) {
        getHome().saveDoc(_COL, new TupleDocument<>(tag));
    }

    @Override
    public boolean exists(String tagId) {
        return getHome().tupleCount(_COL, String.format("{'tuple.id':'%s'}", tagId)) > 0;
    }

    @Override
    public Tag getTag(String tagId) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':'%s'}", _COL, Tag.class.getName(), tagId);
        IQuery<Tag> query = getHome().createQuery(cjql);
        IDocument<Tag> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public void addPropertyTag(String principal, String tagId) {
        long count = getHome().tupleCount(_COL_TAG_PROP, String.format("{'tuple.person':'%s','tuple.tag':'%s'}", principal, tagId));
        if (count > 0) {
            return;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("person", principal);
        map.put("tag", tagId);
        getHome().saveDoc(_COL_TAG_PROP, new TupleDocument<>(map));
    }

    @Override
    public void removePropertyTag(String principal, String tagId) {
        getHome().deleteDocOne(_COL_TAG_PROP, String.format("{'tuple.person':'%s','tuple.tag':'%s'}", principal, tagId));
    }

    @Override
    public List<Tag> listMyPropertyTag(String principal) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s'}", _COL_TAG_PROP, HashMap.class.getName(), principal);
        IQuery<HashMap> query = getHome().createQuery(cjql);
        List<IDocument<HashMap>> documents = query.getResultList();
        List<String> tagIds = new ArrayList<>();
        for (IDocument<HashMap> document : documents) {
            String id = (String) document.tuple().get("tag");
            tagIds.add(id);
        }
        return listTag(tagIds);
    }

    private List<Tag> listTag(List<String> tagIds) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.id':{'$in':%s}}", _COL, Tag.class.getName(), new Gson().toJson(tagIds));
        IQuery<Tag> query = getHome().createQuery(cjql);
        List<IDocument<Tag>> documents = query.getResultList();
        List<Tag> tags = new ArrayList<>();
        for (IDocument<Tag> document : documents) {
            tags.add(document.tuple());
        }
        return tags;
    }

    @Override
    public void addLimitTag(LimitTag tag) {
        if (existsLimitTag(tag.getDirect(), tag.getPerson(), tag.getTag())) {
            return;
        }
        getHome().saveDoc(_COL_TAG_LIMIT, new TupleDocument<>(tag));
    }

    private boolean existsLimitTag(String direct, String person, String tag) {
        return getHome().tupleCount(_COL_TAG_LIMIT, String.format("{'tuple.person':'%s','tuple.direct':'%s','tuple.tag':'%s'}", person, direct, tag)) > 0;
    }

    @Override
    public void removeLimitTag(String person, String direct, String tag) {
        getHome().deleteDocOne(_COL_TAG_LIMIT, String.format("{'tuple.person':'%s','tuple.direct':'%s','tuple.tag':'%s'}", person, direct, tag));
    }

    @Override
    public List<Tag> listLimitTag(String principal, String direct) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s','tuple.direct':'%s'}", _COL_TAG_LIMIT, LimitTag.class.getName(), principal, direct);
        IQuery<LimitTag> query = getHome().createQuery(cjql);
        List<IDocument<LimitTag>> documents = query.getResultList();
        List<String> tagIds = new ArrayList<>();
        for (IDocument<LimitTag> document : documents) {
            tagIds.add(document.tuple().getTag());
        }
        return listTag(tagIds);
    }

    @Override
    public void setLimitArea(LimitArea area) {
        long count = getHome().tupleCount(_COL_AREA_LIMIT, String.format("{'tuple.person':'%s','tuple.direct':'%s'}", area.getPerson(), area.getDirect()));
        if (count > 0) {
            removeLimitArea(area.getPerson(), area.getDirect());
        }
        getHome().saveDoc(_COL_AREA_LIMIT, new TupleDocument<>(area));
    }

    @Override
    public void removeLimitArea(String principal, String direct) {
        getHome().deleteDocOne(_COL_AREA_LIMIT, String.format("{'tuple.person':'%s','tuple.direct':'%s'}", principal, direct));
    }

    @Override
    public LimitArea getLimitArea(String principal, String direct) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s','tuple.direct':'%s'}", _COL_AREA_LIMIT, LimitArea.class.getName(), principal, direct);
        IQuery<LimitArea> query = getHome().createQuery(cjql);
        IDocument<LimitArea> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public void setAttachment(Attachment attachment) {
        emptyAttachment(attachment.getPerson());
        getHome().saveDoc(_COL_ATTACH, new TupleDocument<>(attachment));
    }

    @Override
    public void emptyAttachment(String principal) {
        getHome().deleteDocOne(_COL_ATTACH, String.format("{'tuple.person':'%s'}", principal));
    }

    @Override
    public Attachment getAttachment(String principal) {
        String cjql = String.format("select {'tuple':'*'} from tuple %s %s where {'tuple.person':'%s'}", _COL_ATTACH, Attachment.class.getName(), principal);
        IQuery<Attachment> query = getHome().createQuery(cjql);
        IDocument<Attachment> document = query.getSingleResult();
        if (document == null) {
            return null;
        }
        return document.tuple();
    }

    @Override
    public void setAdvert(String principal, String note) {
        Attachment attachment = getAttachment(principal);
        if (attachment == null) {
            return;
        }
        String filter = String.format("{'tuple.person':'%s'}", principal);
        String update = String.format("{'$set':{'tuple.note':'%s'}}", note);
        getHome().updateDocOne(_COL_ATTACH, Document.parse(filter), Document.parse(update));
    }
}
