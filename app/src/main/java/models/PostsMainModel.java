package models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anmol on 28/5/15.
 */
public class PostsMainModel {

    public class Tag {

        @SerializedName("term_id")
        @Expose
        private int termId;
        @Expose
        private String name;
        @Expose
        private String slug;
        @SerializedName("term_group")
        @Expose
        private int termGroup;
        @SerializedName("term_taxonomy_id")
        @Expose
        private int termTaxonomyId;
        @Expose
        private String taxonomy;
        @Expose
        private String description;
        @Expose
        private int parent;
        @Expose
        private int count;
        @Expose
        private String filter;

        /**
         *
         * @return
         * The termId
         */
        public int getTermId() {
            return termId;
        }

        /**
         *
         * @param termId
         * The term_id
         */
        public void setTermId(int termId) {
            this.termId = termId;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         *
         * @param slug
         * The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         *
         * @return
         * The termGroup
         */
        public int getTermGroup() {
            return termGroup;
        }

        /**
         *
         * @param termGroup
         * The term_group
         */
        public void setTermGroup(int termGroup) {
            this.termGroup = termGroup;
        }

        /**
         *
         * @return
         * The termTaxonomyId
         */
        public int getTermTaxonomyId() {
            return termTaxonomyId;
        }

        /**
         *
         * @param termTaxonomyId
         * The term_taxonomy_id
         */
        public void setTermTaxonomyId(int termTaxonomyId) {
            this.termTaxonomyId = termTaxonomyId;
        }

        /**
         *
         * @return
         * The taxonomy
         */
        public String getTaxonomy() {
            return taxonomy;
        }

        /**
         *
         * @param taxonomy
         * The taxonomy
         */
        public void setTaxonomy(String taxonomy) {
            this.taxonomy = taxonomy;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The parent
         */
        public int getParent() {
            return parent;
        }

        /**
         *
         * @param parent
         * The parent
         */
        public void setParent(int parent) {
            this.parent = parent;
        }

        /**
         *
         * @return
         * The count
         */
        public int getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(int count) {
            this.count = count;
        }

        /**
         *
         * @return
         * The filter
         */
        public String getFilter() {
            return filter;
        }

        /**
         *
         * @param filter
         * The filter
         */
        public void setFilter(String filter) {
            this.filter = filter;
        }

    }

    public class Post {

        @Expose
        private String id;
        @Expose
        private String type;
        @Expose
        private String slug;
        @Expose
        private String url;
        @Expose
        private String status;
        @Expose
        private String title;
        @SerializedName("title_plain")
        @Expose
        private String titlePlain;
        @Expose
        private String date;
        @Expose
        private String modified;
        @Expose
        private String excerpt;
        @Expose
        private String parent;
        @Expose
        private List<Category> category = new ArrayList<Category>();
        @Expose
        private List<Tag> tag = new ArrayList<Tag>();
        @Expose
        private List<Author> author = new ArrayList<Author>();
        @SerializedName("comment_count")
        @Expose
        private String commentCount;
        @SerializedName("comment_status")
        @Expose
        private String commentStatus;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The type
         */
        public String getType() {
            return type;
        }

        /**
         *
         * @param type
         * The type
         */
        public void setType(String type) {
            this.type = type;
        }

        /**
         *
         * @return
         * The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         *
         * @param slug
         * The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The status
         */
        public String getStatus() {
            return status;
        }

        /**
         *
         * @param status
         * The status
         */
        public void setStatus(String status) {
            this.status = status;
        }

        /**
         *
         * @return
         * The title
         */
        public String getTitle() {
            return title;
        }

        /**
         *
         * @param title
         * The title
         */
        public void setTitle(String title) {
            this.title = title;
        }

        /**
         *
         * @return
         * The titlePlain
         */
        public String getTitlePlain() {
            return titlePlain;
        }

        /**
         *
         * @param titlePlain
         * The title_plain
         */
        public void setTitlePlain(String titlePlain) {
            this.titlePlain = titlePlain;
        }

        /**
         *
         * @return
         * The date
         */
        public String getDate() {
            return date;
        }

        /**
         *
         * @param date
         * The date
         */
        public void setDate(String date) {
            this.date = date;
        }

        /**
         *
         * @return
         * The modified
         */
        public String getModified() {
            return modified;
        }

        /**
         *
         * @param modified
         * The modified
         */
        public void setModified(String modified) {
            this.modified = modified;
        }

        /**
         *
         * @return
         * The excerpt
         */
        public String getExcerpt() {
            return excerpt;
        }

        /**
         *
         * @param excerpt
         * The excerpt
         */
        public void setExcerpt(String excerpt) {
            this.excerpt = excerpt;
        }

        /**
         *
         * @return
         * The parent
         */
        public String getParent() {
            return parent;
        }

        /**
         *
         * @param parent
         * The parent
         */
        public void setParent(String parent) {
            this.parent = parent;
        }

        /**
         *
         * @return
         * The category
         */
        public List<Category> getCategory() {
            return category;
        }

        /**
         *
         * @param category
         * The category
         */
        public void setCategory(List<Category> category) {
            this.category = category;
        }

        /**
         *
         * @return
         * The tag
         */
        public List<Tag> getTag() {
            return tag;
        }

        /**
         *
         * @param tag
         * The tag
         */
        public void setTag(List<Tag> tag) {
            this.tag = tag;
        }

        /**
         *
         * @return
         * The author
         */
        public List<Author> getAuthor() {
            return author;
        }

        /**
         *
         * @param author
         * The author
         */
        public void setAuthor(List<Author> author) {
            this.author = author;
        }

        /**
         *
         * @return
         * The commentCount
         */
        public String getCommentCount() {
            return commentCount;
        }

        /**
         *
         * @param commentCount
         * The comment_count
         */
        public void setCommentCount(String commentCount) {
            this.commentCount = commentCount;
        }

        /**
         *
         * @return
         * The commentStatus
         */
        public String getCommentStatus() {
            return commentStatus;
        }

        /**
         *
         * @param commentStatus
         * The comment_status
         */
        public void setCommentStatus(String commentStatus) {
            this.commentStatus = commentStatus;
        }

    }

    @Expose
    private String status;
    @Expose
    private int count;
    private int currPage;
    @SerializedName("count_total")
    @Expose
    private int countTotal;
    @Expose
    private int pages;
    @Expose
    private ArrayList<Post> posts = new ArrayList<Post>();

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     *
     * @return
     * The count
     */
    public int getCount() {
        return count;
    }

    /**
     *
     * @param count
     * The count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     *
     * @return
     * The countTotal
     */
    public int getCountTotal() {
        return countTotal;
    }

    /**
     *
     * @param countTotal
     * The count_total
     */
    public void setCountTotal(int countTotal) {
        this.countTotal = countTotal;
    }

    /**
     *
     * @return
     * The pages
     */
    public int getPages() {
        return pages;
    }

    /**
     *
     * @param pages
     * The pages
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     *
     * @return
     * The posts
     */
    public ArrayList<Post> getPosts() {
        return posts;
    }

    /**
     *
     * @param posts
     * The posts
     */
    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }


    public class Category {

        @SerializedName("term_id")
        @Expose
        private int termId;
        @Expose
        private String name;
        @Expose
        private String slug;
        @SerializedName("term_group")
        @Expose
        private int termGroup;
        @SerializedName("term_taxonomy_id")
        @Expose
        private int termTaxonomyId;
        @Expose
        private String taxonomy;
        @Expose
        private String description;
        @Expose
        private int parent;
        @Expose
        private int count;
        @Expose
        private String filter;
        @SerializedName("cat_ID")
        @Expose
        private int catID;
        @SerializedName("category_count")
        @Expose
        private int categoryCount;
        @SerializedName("category_description")
        @Expose
        private String categoryDescription;
        @SerializedName("cat_name")
        @Expose
        private String catName;
        @SerializedName("category_nicename")
        @Expose
        private String categoryNicename;
        @SerializedName("category_parent")
        @Expose
        private int categoryParent;

        /**
         *
         * @return
         * The termId
         */
        public int getTermId() {
            return termId;
        }

        /**
         *
         * @param termId
         * The term_id
         */
        public void setTermId(int termId) {
            this.termId = termId;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         *
         * @param slug
         * The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         *
         * @return
         * The termGroup
         */
        public int getTermGroup() {
            return termGroup;
        }

        /**
         *
         * @param termGroup
         * The term_group
         */
        public void setTermGroup(int termGroup) {
            this.termGroup = termGroup;
        }

        /**
         *
         * @return
         * The termTaxonomyId
         */
        public int getTermTaxonomyId() {
            return termTaxonomyId;
        }

        /**
         *
         * @param termTaxonomyId
         * The term_taxonomy_id
         */
        public void setTermTaxonomyId(int termTaxonomyId) {
            this.termTaxonomyId = termTaxonomyId;
        }

        /**
         *
         * @return
         * The taxonomy
         */
        public String getTaxonomy() {
            return taxonomy;
        }

        /**
         *
         * @param taxonomy
         * The taxonomy
         */
        public void setTaxonomy(String taxonomy) {
            this.taxonomy = taxonomy;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The parent
         */
        public int getParent() {
            return parent;
        }

        /**
         *
         * @param parent
         * The parent
         */
        public void setParent(int parent) {
            this.parent = parent;
        }

        /**
         *
         * @return
         * The count
         */
        public int getCount() {
            return count;
        }

        /**
         *
         * @param count
         * The count
         */
        public void setCount(int count) {
            this.count = count;
        }

        /**
         *
         * @return
         * The filter
         */
        public String getFilter() {
            return filter;
        }

        /**
         *
         * @param filter
         * The filter
         */
        public void setFilter(String filter) {
            this.filter = filter;
        }

        /**
         *
         * @return
         * The catID
         */
        public int getCatID() {
            return catID;
        }

        /**
         *
         * @param catID
         * The cat_ID
         */
        public void setCatID(int catID) {
            this.catID = catID;
        }

        /**
         *
         * @return
         * The categoryCount
         */
        public int getCategoryCount() {
            return categoryCount;
        }

        /**
         *
         * @param categoryCount
         * The category_count
         */
        public void setCategoryCount(int categoryCount) {
            this.categoryCount = categoryCount;
        }

        /**
         *
         * @return
         * The categoryDescription
         */
        public String getCategoryDescription() {
            return categoryDescription;
        }

        /**
         *
         * @param categoryDescription
         * The category_description
         */
        public void setCategoryDescription(String categoryDescription) {
            this.categoryDescription = categoryDescription;
        }

        /**
         *
         * @return
         * The catName
         */
        public String getCatName() {
            return catName;
        }

        /**
         *
         * @param catName
         * The cat_name
         */
        public void setCatName(String catName) {
            this.catName = catName;
        }

        /**
         *
         * @return
         * The categoryNicename
         */
        public String getCategoryNicename() {
            return categoryNicename;
        }

        /**
         *
         * @param categoryNicename
         * The category_nicename
         */
        public void setCategoryNicename(String categoryNicename) {
            this.categoryNicename = categoryNicename;
        }

        /**
         *
         * @return
         * The categoryParent
         */
        public int getCategoryParent() {
            return categoryParent;
        }

        /**
         *
         * @param categoryParent
         * The category_parent
         */
        public void setCategoryParent(int categoryParent) {
            this.categoryParent = categoryParent;
        }

    }

    public class Author {

        @Expose
        private String id;
        @Expose
        private String slug;
        @Expose
        private String name;
        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @Expose
        private String nickname;
        @Expose
        private String url;
        @Expose
        private String description;
        @Expose
        private String gravatar;

        /**
         *
         * @return
         * The id
         */
        public String getId() {
            return id;
        }

        /**
         *
         * @param id
         * The id
         */
        public void setId(String id) {
            this.id = id;
        }

        /**
         *
         * @return
         * The slug
         */
        public String getSlug() {
            return slug;
        }

        /**
         *
         * @param slug
         * The slug
         */
        public void setSlug(String slug) {
            this.slug = slug;
        }

        /**
         *
         * @return
         * The name
         */
        public String getName() {
            return name;
        }

        /**
         *
         * @param name
         * The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         *
         * @return
         * The firstName
         */
        public String getFirstName() {
            return firstName;
        }

        /**
         *
         * @param firstName
         * The first_name
         */
        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        /**
         *
         * @return
         * The lastName
         */
        public String getLastName() {
            return lastName;
        }

        /**
         *
         * @param lastName
         * The last_name
         */
        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        /**
         *
         * @return
         * The nickname
         */
        public String getNickname() {
            return nickname;
        }

        /**
         *
         * @param nickname
         * The nickname
         */
        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        /**
         *
         * @return
         * The url
         */
        public String getUrl() {
            return url;
        }

        /**
         *
         * @param url
         * The url
         */
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         *
         * @return
         * The description
         */
        public String getDescription() {
            return description;
        }

        /**
         *
         * @param description
         * The description
         */
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         *
         * @return
         * The gravatar
         */
        public String getGravatar() {
            return gravatar;
        }

        /**
         *
         * @param gravatar
         * The gravatar
         */
        public void setGravatar(String gravatar) {
            this.gravatar = gravatar;
        }

    }
}
