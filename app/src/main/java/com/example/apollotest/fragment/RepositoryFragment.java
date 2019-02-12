package com.example.apollotest.fragment;

import com.apollographql.apollo.api.GraphqlFragment;
import com.apollographql.apollo.api.ResponseField;
import com.apollographql.apollo.api.ResponseFieldMapper;
import com.apollographql.apollo.api.ResponseFieldMarshaller;
import com.apollographql.apollo.api.ResponseReader;
import com.apollographql.apollo.api.ResponseWriter;
import com.apollographql.apollo.api.internal.Utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.Generated;

@Generated("Apollo GraphQL")
public class RepositoryFragment implements GraphqlFragment {
  static final ResponseField[] $responseFields = {
    ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forString("name", "name", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forString("full_name", "full_name", null, false, Collections.<ResponseField.Condition>emptyList()),
    ResponseField.forObject("owner", "owner", null, true, Collections.<ResponseField.Condition>emptyList())
  };

  public static final String FRAGMENT_DEFINITION = "fragment RepositoryFragment on Repository {\n"
      + "  __typename\n"
      + "  name\n"
      + "  full_name\n"
      + "  owner {\n"
      + "    __typename\n"
      + "    login\n"
      + "  }\n"
      + "}";

  public static final List<String> POSSIBLE_TYPES = Collections.unmodifiableList(Arrays.asList( "Repository"));

  final @NotNull String __typename;

  final @NotNull String name;

  final @NotNull String full_name;

  final @Nullable Owner owner;

  private transient volatile String $toString;

  private transient volatile int $hashCode;

  private transient volatile boolean $hashCodeMemoized;

  public RepositoryFragment(@NotNull String __typename, @NotNull String name,
      @NotNull String full_name, @Nullable Owner owner) {
    this.__typename = Utils.checkNotNull(__typename, "__typename == null");
    this.name = Utils.checkNotNull(name, "name == null");
    this.full_name = Utils.checkNotNull(full_name, "full_name == null");
    this.owner = owner;
  }

  public @NotNull String __typename() {
    return this.__typename;
  }

  /**
   * Just the name of the repository, e.g. GitHunt-API
   */
  public @NotNull String name() {
    return this.name;
  }

  /**
   * The full name of the repository with the username, e.g. apollostack/GitHunt-API
   */
  public @NotNull String full_name() {
    return this.full_name;
  }

  /**
   * The owner of this repository on GitHub, e.g. apollostack
   */
  public @Nullable Owner owner() {
    return this.owner;
  }

  public ResponseFieldMarshaller marshaller() {
    return new ResponseFieldMarshaller() {
      @Override
      public void marshal(ResponseWriter writer) {
        writer.writeString($responseFields[0], __typename);
        writer.writeString($responseFields[1], name);
        writer.writeString($responseFields[2], full_name);
        writer.writeObject($responseFields[3], owner != null ? owner.marshaller() : null);
      }
    };
  }

  @Override
  public String toString() {
    if ($toString == null) {
      $toString = "RepositoryFragment{"
        + "__typename=" + __typename + ", "
        + "name=" + name + ", "
        + "full_name=" + full_name + ", "
        + "owner=" + owner
        + "}";
    }
    return $toString;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RepositoryFragment) {
      RepositoryFragment that = (RepositoryFragment) o;
      return this.__typename.equals(that.__typename)
       && this.name.equals(that.name)
       && this.full_name.equals(that.full_name)
       && ((this.owner == null) ? (that.owner == null) : this.owner.equals(that.owner));
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
      h ^= name.hashCode();
      h *= 1000003;
      h ^= full_name.hashCode();
      h *= 1000003;
      h ^= (owner == null) ? 0 : owner.hashCode();
      $hashCode = h;
      $hashCodeMemoized = true;
    }
    return $hashCode;
  }

  public static final class Mapper implements ResponseFieldMapper<RepositoryFragment> {
    final Owner.Mapper ownerFieldMapper = new Owner.Mapper();

    @Override
    public RepositoryFragment map(ResponseReader reader) {
      final String __typename = reader.readString($responseFields[0]);
      final String name = reader.readString($responseFields[1]);
      final String full_name = reader.readString($responseFields[2]);
      final Owner owner = reader.readObject($responseFields[3], new ResponseReader.ObjectReader<Owner>() {
        @Override
        public Owner read(ResponseReader reader) {
          return ownerFieldMapper.map(reader);
        }
      });
      return new RepositoryFragment(__typename, name, full_name, owner);
    }
  }

  public static class Owner {
    static final ResponseField[] $responseFields = {
      ResponseField.forString("__typename", "__typename", null, false, Collections.<ResponseField.Condition>emptyList()),
      ResponseField.forString("login", "login", null, false, Collections.<ResponseField.Condition>emptyList())
    };

    final @NotNull String __typename;

    final @NotNull String login;

    private transient volatile String $toString;

    private transient volatile int $hashCode;

    private transient volatile boolean $hashCodeMemoized;

    public Owner(@NotNull String __typename, @NotNull String login) {
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
        $toString = "Owner{"
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
      if (o instanceof Owner) {
        Owner that = (Owner) o;
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

    public static final class Mapper implements ResponseFieldMapper<Owner> {
      @Override
      public Owner map(ResponseReader reader) {
        final String __typename = reader.readString($responseFields[0]);
        final String login = reader.readString($responseFields[1]);
        return new Owner(__typename, login);
      }
    }
  }
}
