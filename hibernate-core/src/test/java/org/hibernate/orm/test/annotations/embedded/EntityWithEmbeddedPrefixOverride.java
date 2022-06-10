package org.hibernate.orm.test.annotations.embedded;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.EmbeddedPrefixOverride;

@Entity
@Table(name = "TableEmbeddedPrefixOverride")
public class EntityWithEmbeddedPrefixOverride {

  @Id
  @GeneratedValue
  private Integer id;

  @Embedded
  @EmbeddedPrefixOverride(value = "overridden")
  private EntityWithEmbeddedPrefixOverride.EmbeddableExample embed;

  @Embedded
  private EntityWithEmbeddedPrefixOverride.EmbeddableExample embedNotOverridden;

  @Embedded
  private EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample nestedEmbedNotOverridden;

  @Embedded
  @EmbeddedPrefixOverride(value = "overriddenEmbedded")
  @AttributeOverride(name = "embed.someString", column = @Column(name = "nestedOverriddenColumn"))
  private EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample nestedEmbed;

  @Embeddable
  public static class NestedEmbeddableExample {

    private Integer someInteger;

    @Embedded
    private EntityWithEmbeddedPrefixOverride.EmbeddableExample embedNotOverridden;

    @Embedded
    @EmbeddedPrefixOverride(value = "overriddenEmbedNested")
    private EntityWithEmbeddedPrefixOverride.EmbeddableExample embed;

    public Integer getSomeInteger() {
      return someInteger;
    }

    public void setSomeInteger(Integer someInteger) {
      this.someInteger = someInteger;
    }

    public EntityWithEmbeddedPrefixOverride.EmbeddableExample getEmbedNotOverridden() {
      return embedNotOverridden;
    }

    public void setEmbedNotOverridden(EntityWithEmbeddedPrefixOverride.EmbeddableExample embedNotOverridden) {
      this.embedNotOverridden = embedNotOverridden;
    }

    public EntityWithEmbeddedPrefixOverride.EmbeddableExample getEmbed() {
      return embed;
    }

    public void setEmbed(EntityWithEmbeddedPrefixOverride.EmbeddableExample embed) {
      this.embed = embed;
    }
  }

  @Embeddable
  public static class EmbeddableExample {

    private String someString;

    public String getSomeString() {
      return someString;
    }

    public void setSomeString(String someString) {
      this.someString = someString;
    }
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public EntityWithEmbeddedPrefixOverride.EmbeddableExample getEmbed() {
    return embed;
  }

  public void setEmbed(EntityWithEmbeddedPrefixOverride.EmbeddableExample embed) {
    this.embed = embed;
  }

  public EntityWithEmbeddedPrefixOverride.EmbeddableExample getEmbedNotOverridden() {
    return embedNotOverridden;
  }

  public void setEmbedNotOverridden(EntityWithEmbeddedPrefixOverride.EmbeddableExample embedNotOverridden) {
    this.embedNotOverridden = embedNotOverridden;
  }

  public EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample getNestedEmbedNotOverridden() {
    return nestedEmbedNotOverridden;
  }

  public void setNestedEmbedNotOverridden(EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample nestedEmbedNotOverridden) {
    this.nestedEmbedNotOverridden = nestedEmbedNotOverridden;
  }

  public EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample getNestedEmbed() {
    return nestedEmbed;
  }

  public void setNestedEmbed(EntityWithEmbeddedPrefixOverride.NestedEmbeddableExample nestedEmbed) {
    this.nestedEmbed = nestedEmbed;
  }
}