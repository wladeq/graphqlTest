package com.example.apollotest;

import com.apollographql.apollo.api.FragmentResponseFieldMapper;
import com.apollographql.apollo.api.InputFieldMarshaller;
import com.apollographql.apollo.api.InputFieldWriter;
import com.apollographql.apollo.api.Operation;
import com.apollographql.apollo.api.OperationName;
import com.apollographql.apollo.api.Query;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.UnmodifiableMapBuilder;
import com.apollographql.apollo.api.internal.Utils;
import com.example.apollotest.fragment.RepositoryFragment;
import com.example.apollotest.type.FeedType;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

@Generated("Apollo GraphQL")
public final class TestQuery implements Query<TestQuery.Data, TestQuery.Data, TestQuery.Variables> {
  public static final String OPERATION_ID = "0b6ca4c466e35ce114dddcd850c23a00befaab139227758aed1df696a938ffa1";

//  public static final String QUERY_DOCUMENT = "query TestQuery($type: FeedType!, $limit: Int!) {\n"
//      + "  feedEntries: feed(type: $type, limit: $limit) {\n"
//      + "    __typename\n"
//      + "    id\n"
//      + "    repository {\n"
//      + "      __typename\n"
//      + "      ...RepositoryFragment\n"
//      + "    }\n"
//      + "    postedBy {\n"
//      + "      __typename\n"
//      + "      login\n"
//      + "    }\n"
//      + "  }\n"
//      + "}\n"
//      + "fragment RepositoryFragment on Repository {\n"
//      + "  __typename\n"
//      + "  name\n"
//      + "  full_name\n"
//      + "  owner {\n"
//      + "    __typename\n"
//      + "    login\n"
//      + "  }\n"
//      + "}";
  public static final String QUERY_DOCUMENT = "query{\n"
      + "__schema{\n"
      + "types{\n"
      + "kind\n"
      + "  }\n"
      + " }\n"
      + "}\n";

  public static final OperationName OPERATION_NAME = new OperationName() {
    @Override
    public String name() {
      return "";
    }
  };

  private final Variables variables;

  public TestQuery(@NotNull FeedType type, int limit) {
    Utils.checkNotNull(type, "type == null");
    variables = new Variables(type, limit);
  }

  @Override
  public String operationId() {
    return OPERATION_ID;
  }

  @Override
  public String queryDocument() {
    return QUERY_DOCUMENT;
  }

  @Override
  public Data wrapData(Data data) {
    return data;
  }

  @Override
  public Variables variables() {
    return variables;
  }

  @Override
  public ResponseFieldMapper<Data> responseFieldMapper() {
    return new Data.Mapper();
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public OperationName name() {
    return OPERATION_NAME;
  }

  public static final class Builder {
    private @NotNull FeedType type;

    private int limit;

    Builder() {
    }

    public Builder type(@NotNull FeedType type) {
      this.type = type;
      return this;
    }

    public Builder limit(int limit) {
      this.limit = limit;
      return this;
    }

    public TestQuery build() {
      Utils.checkNotNull(type, "type == null");
      return new TestQuery(type, limit);
    }
  }

  public static final class Variables extends Operation.Variables {
    private final @NotNull FeedType type;

    private final int limit;

    private final transient Map<String, Object> valueMap = new LinkedHashMap<>();

    Variables(@NotNull FeedType type, int limit) {
      this.type = type;
      this.limit = limit;
      this.valueMap.put("type", type);
      this.valueMap.put("limit", limit);
    }

    public @NotNull FeedType type() {
      return type;
    }

    public int limit() {
      return limit;
    }

    @Override
    public Map<String, Object> valueMap() {
      return Collections.unmodifiableMap(valueMap);
    }

    @Override
    public InputFieldMarshaller marshaller() {
      return new InputFieldMarshaller() {
        @Override
        public void marshal(InputFieldWriter writer) throws IOException {
          writer.writeString("type", type.rawValue());
          writer.writeInt("limit", limit);
        }
      };
    }
  }

  public static class Data implements Operation.Data {
    static final ResponseField[] $responseFields = {
      ResponseField.forList("feedEntries", "feed", new UnmodifiableMapBuilder<String, Object>(2)
      .put("type", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "type")
        .build())
      .put("limit", new UnmodifiableMapBuilder<String, Object>(2)
        .put("kind", "Variable")
        .put("variableName", "limit")
        .build())
      .build(), true, Collections.<ResponseField.Condition>emptyList())
    };

    final @Nullable List<FeedEntry> feedEntries;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Data(@Nullable List<FeedEntry> feedEntries) {
      this.feedEntries = feedEntries;
    }

    /**
     * A feed of repository submissions
     */
    public @Nullable List<FeedEntry> feedEntries() {
      return this.feedEntries;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeList($responseFields[0], feedEntries, new ResponseWriter.ListWriter() {
            @Override
            public void write(List items, ResponseWriter.ListItemWriter listItemWriter) {
              for (Object item : items) {
                listItemWriter.writeObject(((FeedEntry) item).marshaller());
              }
            }
          });
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Data{"
          + "feedEntries=" + feedEntries
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Data) {
        Data that = (Data) o;
        return ((this.feedEntries == null) ? (that.feedEntries == null) : this.feedEntries.equals(that.feedEntries));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= (feedEntries == null) ? 0 : feedEntries.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<Data> {
      final FeedEntry.Mapper feedEntryFieldMapper = new FeedEntry.Mapper();

      @Override
      public Data map(ResponseReader reader) {
        final List<FeedEntry> feedEntries = reader.readList($responseFields[0], new ResponseReader.ListReader<FeedEntry>() {
          @Override
          public FeedEntry read(ResponseReader.ListItemReader listItemReader) {
            return listItemReader.readObject(new ResponseReader.ObjectReader<FeedEntry>() {
              @Override
              public FeedEntry read(ResponseReader reader) {
                return feedEntryFieldMapper.map(reader);
              }
            });
          }
        });
        return new Data(feedEntries);
      }
    }
  }

  public static class FeedEntry {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forInt("id", "id", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("repository", "repository", null, true, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forObject("postedBy", "postedBy", null, true, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final int id;

    final @Nullable Repository repository;

    final @Nullable PostedBy postedBy;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public FeedEntry(@NotNull String __typename, int id, @Nullable Repository repository,
        @Nullable PostedBy postedBy) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.id = id;
      this.repository = repository;
      this.postedBy = postedBy;
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The SQL ID of this entry
     */
    public int id() {
      return this.id;
    }

    /**
     * Information about the repository from GitHub
     */
    public @Nullable Repository repository() {
      return this.repository;
    }

    /**
     * The GitHub user who submitted this entry
     */
    public @Nullable PostedBy postedBy() {
      return this.postedBy;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeInt($responseFields[1], id);
          writer.writeObject($responseFields[2], repository != null ? repository.marshaller() : null);
          writer.writeObject($responseFields[3], postedBy != null ? postedBy.marshaller() : null);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "FeedEntry{"
          + "__typename=" + __typename + ", "
          + "id=" + id + ", "
          + "repository=" + repository + ", "
          + "postedBy=" + postedBy
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof FeedEntry) {
        FeedEntry that = (FeedEntry) o;
        return this.__typename.equals(that.__typename)
         && this.id == that.id
         && ((this.repository == null) ? (that.repository == null) : this.repository.equals(that.repository))
         && ((this.postedBy == null) ? (that.postedBy == null) : this.postedBy.equals(that.postedBy));
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= id;
        h *= 1000003;
        h ^= (repository == null) ? 0 : repository.hashCode();
        h *= 1000003;
        h ^= (postedBy == null) ? 0 : postedBy.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<FeedEntry> {
      final Repository.Mapper repositoryFieldMapper = new Repository.Mapper();

      final PostedBy.Mapper postedByFieldMapper = new PostedBy.Mapper();

      @Override
      public FeedEntry map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final int id = reader.readInt($responseFields[1]);
        final Repository repository = reader.readObject($responseFields[2], new ResponseReader.ObjectReader<Repository>() {
          @Override
          public Repository read(ResponseReader reader) {
            return repositoryFieldMapper.map(reader);
          }
        });
        final PostedBy postedBy = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<PostedBy>() {
          @Override
          public PostedBy read(ResponseReader reader) {
            return postedByFieldMapper.map(reader);
          }
        });
        return new FeedEntry(__typename, id, repository, postedBy);
      }
    }
  }

  public static class Repository {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forFragment("__typename", "__typename", Arrays.asList("Repository"))
    };

    final @NotNull String __typename;

    private final @NotNull Fragments fragments;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Repository(@NotNull String __typename, @NotNull Fragments fragments) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.fragments = Utils.checkNotNull(fragments, "fragments == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    public @NotNull Fragments fragments() {
      return this.fragments;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          fragments.marshaller().marshal(writer);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "Repository{"
          + "__typename=" + __typename + ", "
          + "fragments=" + fragments
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof Repository) {
        Repository that = (Repository) o;
        return this.__typename.equals(that.__typename)
         && this.fragments.equals(that.fragments);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= fragments.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static class Fragments {
      final @NotNull RepositoryFragment repositoryFragment;

      private transient volatile String $toString;

      private transient volatile int $hashCode;

      private transient volatile boolean $hashCodeMemoized;

      public Fragments(@NotNull RepositoryFragment repositoryFragment) {
        this.repositoryFragment = Utils.checkNotNull(repositoryFragment, "repositoryFragment == null");
      }

      public @NotNull RepositoryFragment repositoryFragment() {
        return this.repositoryFragment;
      }

      public ResponseFieldMarshaller marshaller() {
        return new ResponseFieldMarshaller() {
          @Override
          public void marshal(ResponseWriter writer) {
            final RepositoryFragment $repositoryFragment = repositoryFragment;
            if ($repositoryFragment != null) {
              $repositoryFragment.marshaller().marshal(writer);
            }
          }
        };
      }

      @Override
      public String toString() {
        if ($toString == null) {
          $toString = "Fragments{"
            + "repositoryFragment=" + repositoryFragment
            + "}";
        }
        return $toString;
      }

      @Override
      public boolean equals(Object o) {
        if (o == this) {
          return true;
        }
        if (o instanceof Fragments) {
          Fragments that = (Fragments) o;
          return this.repositoryFragment.equals(that.repositoryFragment);
        }
        return false;
      }

      @Override
      public int hashCode() {
        if (!$hashCodeMemoized) {
          int h = 1;
          h *= 1000003;
          h ^= repositoryFragment.hashCode();
          $hashCode = h;
          $hashCodeMemoized = true;
        }
        return $hashCode;
      }

      public static final class Mapper implements FragmentResponseFieldMapper<Fragments> {
        final RepositoryFragment.Mapper repositoryFragmentFieldMapper = new RepositoryFragment.Mapper();

        @Override
        public @NotNull Fragments map(ResponseReader reader, @NotNull String conditionalType) {
          RepositoryFragment repositoryFragment = null;
          if (RepositoryFragment.POSSIBLE_TYPES.contains(conditionalType)) {
            repositoryFragment = repositoryFragmentFieldMapper.map(reader);
          }
          return new Fragments(Utils.checkNotNull(repositoryFragment, "repositoryFragment == null"));
        }
      }
    }

    public static final class Mapper implements ResponseFieldMapper<Repository> {
      final Fragments.Mapper fragmentsFieldMapper = new Fragments.Mapper();

      @Override
      public Repository map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final Fragments fragments = reader.readConditional($responseFields[1], new ResponseReader.ConditionalTypeReader<Fragments>() {
          @Override
          public Fragments read(String conditionalType, ResponseReader reader) {
            return fragmentsFieldMapper.map(reader, conditionalType);
          }
        });
        return new Repository(__typename, fragments);
      }
    }
  }

  public static class PostedBy {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("login", "login", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String login;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public PostedBy(@NotNull String __typename, @NotNull String login) {
      this.__typename = Utils.checkNotNull(__typename, "__typename == null");
      this.login = Utils.checkNotNull(login, "login == null");
    }

    public @NotNull String __typename() {
      return this.__typename;
    }

    /**
     * The name of the user, e.g. apollostack
     */
    public @NotNull String login() {
      return this.login;
    }

    public ResponseFieldMarshaller marshaller() {
      return new ResponseFieldMarshaller() {
        @Override
        public void marshal(ResponseWriter writer) {
          writer.writeString($responseFields[0], __typename);
          writer.writeString($responseFields[1], login);
        }
      };
    }

    @Override
    public String toString() {
      if ($toString == null) {
        $toString = "PostedBy{"
          + "__typename=" + __typename + ", "
          + "login=" + login
          + "}";
      }
      return $toString;
    }

    @Override
    public boolean equals(Object o) {
      if (o == this) {
        return true;
      }
      if (o instanceof PostedBy) {
        PostedBy that = (PostedBy) o;
        return this.__typename.equals(that.__typename)
         && this.login.equals(that.login);
      }
      return false;
    }

    @Override
    public int hashCode() {
      if (!$hashCodeMemoized) {
        int h = 1;
        h *= 1000003;
        h ^= __typename.hashCode();
        h *= 1000003;
        h ^= login.hashCode();
        $hashCode = h;
        $hashCodeMemoized = true;
      }
      return $hashCode;
    }

    public static final class Mapper implements ResponseFieldMapper<PostedBy> {
      @Override
      public PostedBy map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String login = reader.readString($responseFields[1]);
        return new PostedBy(__typename, login);
      }
    }
  }
}
