package com.wenhua.proto;


public final class Wenhua {
  private Wenhua() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface AuthenInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:AuthenInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 barID = 1;</code>
     */
    int getBarID();

    /**
     * <code>string when = 2;</code>
     */
    java.lang.String getWhen();
    /**
     * <code>string when = 2;</code>
     */
    com.google.protobuf.ByteString
        getWhenBytes();

    /**
     * <code>string sign = 3;</code>
     */
    java.lang.String getSign();
    /**
     * <code>string sign = 3;</code>
     */
    com.google.protobuf.ByteString
        getSignBytes();

    /**
     * <code>string svrMac = 4;</code>
     */
    java.lang.String getSvrMac();
    /**
     * <code>string svrMac = 4;</code>
     */
    com.google.protobuf.ByteString
        getSvrMacBytes();
  }
  /**
   * Protobuf type {@code AuthenInfo}
   */
  public  static final class AuthenInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:AuthenInfo)
      AuthenInfoOrBuilder {
    // Use AuthenInfo.newBuilder() to construct.
    private AuthenInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private AuthenInfo() {
      barID_ = 0;
      when_ = "";
      sign_ = "";
      svrMac_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private AuthenInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              barID_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              when_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              sign_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              svrMac_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_AuthenInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_AuthenInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.AuthenInfo.class, Wenhua.AuthenInfo.Builder.class);
    }

    public static final int BARID_FIELD_NUMBER = 1;
    private int barID_;
    /**
     * <code>int32 barID = 1;</code>
     */
    public int getBarID() {
      return barID_;
    }

    public static final int WHEN_FIELD_NUMBER = 2;
    private volatile java.lang.Object when_;
    /**
     * <code>string when = 2;</code>
     */
    public java.lang.String getWhen() {
      java.lang.Object ref = when_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        when_ = s;
        return s;
      }
    }
    /**
     * <code>string when = 2;</code>
     */
    public com.google.protobuf.ByteString
        getWhenBytes() {
      java.lang.Object ref = when_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        when_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SIGN_FIELD_NUMBER = 3;
    private volatile java.lang.Object sign_;
    /**
     * <code>string sign = 3;</code>
     */
    public java.lang.String getSign() {
      java.lang.Object ref = sign_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        sign_ = s;
        return s;
      }
    }
    /**
     * <code>string sign = 3;</code>
     */
    public com.google.protobuf.ByteString
        getSignBytes() {
      java.lang.Object ref = sign_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        sign_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int SVRMAC_FIELD_NUMBER = 4;
    private volatile java.lang.Object svrMac_;
    /**
     * <code>string svrMac = 4;</code>
     */
    public java.lang.String getSvrMac() {
      java.lang.Object ref = svrMac_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        svrMac_ = s;
        return s;
      }
    }
    /**
     * <code>string svrMac = 4;</code>
     */
    public com.google.protobuf.ByteString
        getSvrMacBytes() {
      java.lang.Object ref = svrMac_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        svrMac_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (barID_ != 0) {
        output.writeInt32(1, barID_);
      }
      if (!getWhenBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, when_);
      }
      if (!getSignBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, sign_);
      }
      if (!getSvrMacBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, svrMac_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (barID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, barID_);
      }
      if (!getWhenBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, when_);
      }
      if (!getSignBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, sign_);
      }
      if (!getSvrMacBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, svrMac_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.AuthenInfo)) {
        return super.equals(obj);
      }
      Wenhua.AuthenInfo other = (Wenhua.AuthenInfo) obj;

      boolean result = true;
      result = result && (getBarID()
          == other.getBarID());
      result = result && getWhen()
          .equals(other.getWhen());
      result = result && getSign()
          .equals(other.getSign());
      result = result && getSvrMac()
          .equals(other.getSvrMac());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + BARID_FIELD_NUMBER;
      hash = (53 * hash) + getBarID();
      hash = (37 * hash) + WHEN_FIELD_NUMBER;
      hash = (53 * hash) + getWhen().hashCode();
      hash = (37 * hash) + SIGN_FIELD_NUMBER;
      hash = (53 * hash) + getSign().hashCode();
      hash = (37 * hash) + SVRMAC_FIELD_NUMBER;
      hash = (53 * hash) + getSvrMac().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.AuthenInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.AuthenInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.AuthenInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.AuthenInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.AuthenInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.AuthenInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.AuthenInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.AuthenInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.AuthenInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.AuthenInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.AuthenInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code AuthenInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:AuthenInfo)
        Wenhua.AuthenInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_AuthenInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_AuthenInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.AuthenInfo.class, Wenhua.AuthenInfo.Builder.class);
      }

      // Construct using Wenhua.AuthenInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        barID_ = 0;

        when_ = "";

        sign_ = "";

        svrMac_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_AuthenInfo_descriptor;
      }

      public Wenhua.AuthenInfo getDefaultInstanceForType() {
        return Wenhua.AuthenInfo.getDefaultInstance();
      }

      public Wenhua.AuthenInfo build() {
        Wenhua.AuthenInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.AuthenInfo buildPartial() {
        Wenhua.AuthenInfo result = new Wenhua.AuthenInfo(this);
        result.barID_ = barID_;
        result.when_ = when_;
        result.sign_ = sign_;
        result.svrMac_ = svrMac_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.AuthenInfo) {
          return mergeFrom((Wenhua.AuthenInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.AuthenInfo other) {
        if (other == Wenhua.AuthenInfo.getDefaultInstance()) return this;
        if (other.getBarID() != 0) {
          setBarID(other.getBarID());
        }
        if (!other.getWhen().isEmpty()) {
          when_ = other.when_;
          onChanged();
        }
        if (!other.getSign().isEmpty()) {
          sign_ = other.sign_;
          onChanged();
        }
        if (!other.getSvrMac().isEmpty()) {
          svrMac_ = other.svrMac_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.AuthenInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.AuthenInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int barID_ ;
      /**
       * <code>int32 barID = 1;</code>
       */
      public int getBarID() {
        return barID_;
      }
      /**
       * <code>int32 barID = 1;</code>
       */
      public Builder setBarID(int value) {
        
        barID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 barID = 1;</code>
       */
      public Builder clearBarID() {
        
        barID_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object when_ = "";
      /**
       * <code>string when = 2;</code>
       */
      public java.lang.String getWhen() {
        java.lang.Object ref = when_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          when_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string when = 2;</code>
       */
      public com.google.protobuf.ByteString
          getWhenBytes() {
        java.lang.Object ref = when_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          when_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string when = 2;</code>
       */
      public Builder setWhen(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        when_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string when = 2;</code>
       */
      public Builder clearWhen() {
        
        when_ = getDefaultInstance().getWhen();
        onChanged();
        return this;
      }
      /**
       * <code>string when = 2;</code>
       */
      public Builder setWhenBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        when_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object sign_ = "";
      /**
       * <code>string sign = 3;</code>
       */
      public java.lang.String getSign() {
        java.lang.Object ref = sign_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          sign_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string sign = 3;</code>
       */
      public com.google.protobuf.ByteString
          getSignBytes() {
        java.lang.Object ref = sign_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          sign_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string sign = 3;</code>
       */
      public Builder setSign(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        sign_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string sign = 3;</code>
       */
      public Builder clearSign() {
        
        sign_ = getDefaultInstance().getSign();
        onChanged();
        return this;
      }
      /**
       * <code>string sign = 3;</code>
       */
      public Builder setSignBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        sign_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object svrMac_ = "";
      /**
       * <code>string svrMac = 4;</code>
       */
      public java.lang.String getSvrMac() {
        java.lang.Object ref = svrMac_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          svrMac_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string svrMac = 4;</code>
       */
      public com.google.protobuf.ByteString
          getSvrMacBytes() {
        java.lang.Object ref = svrMac_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          svrMac_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string svrMac = 4;</code>
       */
      public Builder setSvrMac(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        svrMac_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string svrMac = 4;</code>
       */
      public Builder clearSvrMac() {
        
        svrMac_ = getDefaultInstance().getSvrMac();
        onChanged();
        return this;
      }
      /**
       * <code>string svrMac = 4;</code>
       */
      public Builder setSvrMacBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        svrMac_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:AuthenInfo)
    }

    // @@protoc_insertion_point(class_scope:AuthenInfo)
    private static final Wenhua.AuthenInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.AuthenInfo();
    }

    public static Wenhua.AuthenInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<AuthenInfo>
        PARSER = new com.google.protobuf.AbstractParser<AuthenInfo>() {
      public AuthenInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new AuthenInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<AuthenInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<AuthenInfo> getParserForType() {
      return PARSER;
    }

    public Wenhua.AuthenInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface BarConfigOrBuilder extends
      // @@protoc_insertion_point(interface_extends:BarConfig)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 freqInstantPcInfo = 1;</code>
     */
    int getFreqInstantPcInfo();
  }
  /**
   * Protobuf type {@code BarConfig}
   */
  public  static final class BarConfig extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:BarConfig)
      BarConfigOrBuilder {
    // Use BarConfig.newBuilder() to construct.
    private BarConfig(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private BarConfig() {
      freqInstantPcInfo_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private BarConfig(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              freqInstantPcInfo_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_BarConfig_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_BarConfig_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.BarConfig.class, Wenhua.BarConfig.Builder.class);
    }

    public static final int FREQINSTANTPCINFO_FIELD_NUMBER = 1;
    private int freqInstantPcInfo_;
    /**
     * <code>int32 freqInstantPcInfo = 1;</code>
     */
    public int getFreqInstantPcInfo() {
      return freqInstantPcInfo_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (freqInstantPcInfo_ != 0) {
        output.writeInt32(1, freqInstantPcInfo_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (freqInstantPcInfo_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, freqInstantPcInfo_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.BarConfig)) {
        return super.equals(obj);
      }
      Wenhua.BarConfig other = (Wenhua.BarConfig) obj;

      boolean result = true;
      result = result && (getFreqInstantPcInfo()
          == other.getFreqInstantPcInfo());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FREQINSTANTPCINFO_FIELD_NUMBER;
      hash = (53 * hash) + getFreqInstantPcInfo();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.BarConfig parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.BarConfig parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.BarConfig parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.BarConfig parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.BarConfig parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.BarConfig parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.BarConfig parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.BarConfig parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.BarConfig parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.BarConfig parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.BarConfig prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code BarConfig}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:BarConfig)
        Wenhua.BarConfigOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_BarConfig_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_BarConfig_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.BarConfig.class, Wenhua.BarConfig.Builder.class);
      }

      // Construct using Wenhua.BarConfig.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        freqInstantPcInfo_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_BarConfig_descriptor;
      }

      public Wenhua.BarConfig getDefaultInstanceForType() {
        return Wenhua.BarConfig.getDefaultInstance();
      }

      public Wenhua.BarConfig build() {
        Wenhua.BarConfig result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.BarConfig buildPartial() {
        Wenhua.BarConfig result = new Wenhua.BarConfig(this);
        result.freqInstantPcInfo_ = freqInstantPcInfo_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.BarConfig) {
          return mergeFrom((Wenhua.BarConfig)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.BarConfig other) {
        if (other == Wenhua.BarConfig.getDefaultInstance()) return this;
        if (other.getFreqInstantPcInfo() != 0) {
          setFreqInstantPcInfo(other.getFreqInstantPcInfo());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.BarConfig parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.BarConfig) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int freqInstantPcInfo_ ;
      /**
       * <code>int32 freqInstantPcInfo = 1;</code>
       */
      public int getFreqInstantPcInfo() {
        return freqInstantPcInfo_;
      }
      /**
       * <code>int32 freqInstantPcInfo = 1;</code>
       */
      public Builder setFreqInstantPcInfo(int value) {
        
        freqInstantPcInfo_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 freqInstantPcInfo = 1;</code>
       */
      public Builder clearFreqInstantPcInfo() {
        
        freqInstantPcInfo_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:BarConfig)
    }

    // @@protoc_insertion_point(class_scope:BarConfig)
    private static final Wenhua.BarConfig DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.BarConfig();
    }

    public static Wenhua.BarConfig getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<BarConfig>
        PARSER = new com.google.protobuf.AbstractParser<BarConfig>() {
      public BarConfig parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new BarConfig(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<BarConfig> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<BarConfig> getParserForType() {
      return PARSER;
    }

    public Wenhua.BarConfig getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface ServerInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:ServerInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string mac = 1;</code>
     */
    java.lang.String getMac();
    /**
     * <code>string mac = 1;</code>
     */
    com.google.protobuf.ByteString
        getMacBytes();

    /**
     * <code>string ip = 2;</code>
     */
    java.lang.String getIp();
    /**
     * <code>string ip = 2;</code>
     */
    com.google.protobuf.ByteString
        getIpBytes();

    /**
     * <code>string pcname = 3;</code>
     */
    java.lang.String getPcname();
    /**
     * <code>string pcname = 3;</code>
     */
    com.google.protobuf.ByteString
        getPcnameBytes();

    /**
     * <code>int32 os = 4;</code>
     */
    int getOs();

    /**
     * <code>string windows = 5;</code>
     */
    java.lang.String getWindows();
    /**
     * <code>string windows = 5;</code>
     */
    com.google.protobuf.ByteString
        getWindowsBytes();
  }
  /**
   * Protobuf type {@code ServerInfo}
   */
  public  static final class ServerInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:ServerInfo)
      ServerInfoOrBuilder {
    // Use ServerInfo.newBuilder() to construct.
    private ServerInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private ServerInfo() {
      mac_ = "";
      ip_ = "";
      pcname_ = "";
      os_ = 0;
      windows_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private ServerInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              mac_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              ip_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              pcname_ = s;
              break;
            }
            case 32: {

              os_ = input.readInt32();
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              windows_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_ServerInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_ServerInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.ServerInfo.class, Wenhua.ServerInfo.Builder.class);
    }

    public static final int MAC_FIELD_NUMBER = 1;
    private volatile java.lang.Object mac_;
    /**
     * <code>string mac = 1;</code>
     */
    public java.lang.String getMac() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mac_ = s;
        return s;
      }
    }
    /**
     * <code>string mac = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMacBytes() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mac_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int IP_FIELD_NUMBER = 2;
    private volatile java.lang.Object ip_;
    /**
     * <code>string ip = 2;</code>
     */
    public java.lang.String getIp() {
      java.lang.Object ref = ip_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ip_ = s;
        return s;
      }
    }
    /**
     * <code>string ip = 2;</code>
     */
    public com.google.protobuf.ByteString
        getIpBytes() {
      java.lang.Object ref = ip_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ip_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PCNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object pcname_;
    /**
     * <code>string pcname = 3;</code>
     */
    public java.lang.String getPcname() {
      java.lang.Object ref = pcname_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pcname_ = s;
        return s;
      }
    }
    /**
     * <code>string pcname = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPcnameBytes() {
      java.lang.Object ref = pcname_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pcname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OS_FIELD_NUMBER = 4;
    private int os_;
    /**
     * <code>int32 os = 4;</code>
     */
    public int getOs() {
      return os_;
    }

    public static final int WINDOWS_FIELD_NUMBER = 5;
    private volatile java.lang.Object windows_;
    /**
     * <code>string windows = 5;</code>
     */
    public java.lang.String getWindows() {
      java.lang.Object ref = windows_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        windows_ = s;
        return s;
      }
    }
    /**
     * <code>string windows = 5;</code>
     */
    public com.google.protobuf.ByteString
        getWindowsBytes() {
      java.lang.Object ref = windows_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        windows_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMacBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mac_);
      }
      if (!getIpBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ip_);
      }
      if (!getPcnameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, pcname_);
      }
      if (os_ != 0) {
        output.writeInt32(4, os_);
      }
      if (!getWindowsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, windows_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMacBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, mac_);
      }
      if (!getIpBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ip_);
      }
      if (!getPcnameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, pcname_);
      }
      if (os_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, os_);
      }
      if (!getWindowsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, windows_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.ServerInfo)) {
        return super.equals(obj);
      }
      Wenhua.ServerInfo other = (Wenhua.ServerInfo) obj;

      boolean result = true;
      result = result && getMac()
          .equals(other.getMac());
      result = result && getIp()
          .equals(other.getIp());
      result = result && getPcname()
          .equals(other.getPcname());
      result = result && (getOs()
          == other.getOs());
      result = result && getWindows()
          .equals(other.getWindows());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MAC_FIELD_NUMBER;
      hash = (53 * hash) + getMac().hashCode();
      hash = (37 * hash) + IP_FIELD_NUMBER;
      hash = (53 * hash) + getIp().hashCode();
      hash = (37 * hash) + PCNAME_FIELD_NUMBER;
      hash = (53 * hash) + getPcname().hashCode();
      hash = (37 * hash) + OS_FIELD_NUMBER;
      hash = (53 * hash) + getOs();
      hash = (37 * hash) + WINDOWS_FIELD_NUMBER;
      hash = (53 * hash) + getWindows().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.ServerInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.ServerInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.ServerInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.ServerInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.ServerInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.ServerInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.ServerInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.ServerInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.ServerInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.ServerInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.ServerInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code ServerInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:ServerInfo)
        Wenhua.ServerInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_ServerInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_ServerInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.ServerInfo.class, Wenhua.ServerInfo.Builder.class);
      }

      // Construct using Wenhua.ServerInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        mac_ = "";

        ip_ = "";

        pcname_ = "";

        os_ = 0;

        windows_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_ServerInfo_descriptor;
      }

      public Wenhua.ServerInfo getDefaultInstanceForType() {
        return Wenhua.ServerInfo.getDefaultInstance();
      }

      public Wenhua.ServerInfo build() {
        Wenhua.ServerInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.ServerInfo buildPartial() {
        Wenhua.ServerInfo result = new Wenhua.ServerInfo(this);
        result.mac_ = mac_;
        result.ip_ = ip_;
        result.pcname_ = pcname_;
        result.os_ = os_;
        result.windows_ = windows_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.ServerInfo) {
          return mergeFrom((Wenhua.ServerInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.ServerInfo other) {
        if (other == Wenhua.ServerInfo.getDefaultInstance()) return this;
        if (!other.getMac().isEmpty()) {
          mac_ = other.mac_;
          onChanged();
        }
        if (!other.getIp().isEmpty()) {
          ip_ = other.ip_;
          onChanged();
        }
        if (!other.getPcname().isEmpty()) {
          pcname_ = other.pcname_;
          onChanged();
        }
        if (other.getOs() != 0) {
          setOs(other.getOs());
        }
        if (!other.getWindows().isEmpty()) {
          windows_ = other.windows_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.ServerInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.ServerInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object mac_ = "";
      /**
       * <code>string mac = 1;</code>
       */
      public java.lang.String getMac() {
        java.lang.Object ref = mac_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          mac_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMacBytes() {
        java.lang.Object ref = mac_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          mac_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMac(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        mac_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder clearMac() {
        
        mac_ = getDefaultInstance().getMac();
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMacBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        mac_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object ip_ = "";
      /**
       * <code>string ip = 2;</code>
       */
      public java.lang.String getIp() {
        java.lang.Object ref = ip_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          ip_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ip = 2;</code>
       */
      public com.google.protobuf.ByteString
          getIpBytes() {
        java.lang.Object ref = ip_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          ip_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder setIp(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        ip_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder clearIp() {
        
        ip_ = getDefaultInstance().getIp();
        onChanged();
        return this;
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder setIpBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        ip_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object pcname_ = "";
      /**
       * <code>string pcname = 3;</code>
       */
      public java.lang.String getPcname() {
        java.lang.Object ref = pcname_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          pcname_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public com.google.protobuf.ByteString
          getPcnameBytes() {
        java.lang.Object ref = pcname_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pcname_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder setPcname(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        pcname_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder clearPcname() {
        
        pcname_ = getDefaultInstance().getPcname();
        onChanged();
        return this;
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder setPcnameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        pcname_ = value;
        onChanged();
        return this;
      }

      private int os_ ;
      /**
       * <code>int32 os = 4;</code>
       */
      public int getOs() {
        return os_;
      }
      /**
       * <code>int32 os = 4;</code>
       */
      public Builder setOs(int value) {
        
        os_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 os = 4;</code>
       */
      public Builder clearOs() {
        
        os_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object windows_ = "";
      /**
       * <code>string windows = 5;</code>
       */
      public java.lang.String getWindows() {
        java.lang.Object ref = windows_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          windows_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string windows = 5;</code>
       */
      public com.google.protobuf.ByteString
          getWindowsBytes() {
        java.lang.Object ref = windows_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          windows_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder setWindows(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        windows_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder clearWindows() {
        
        windows_ = getDefaultInstance().getWindows();
        onChanged();
        return this;
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder setWindowsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        windows_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:ServerInfo)
    }

    // @@protoc_insertion_point(class_scope:ServerInfo)
    private static final Wenhua.ServerInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.ServerInfo();
    }

    public static Wenhua.ServerInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<ServerInfo>
        PARSER = new com.google.protobuf.AbstractParser<ServerInfo>() {
      public ServerInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new ServerInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<ServerInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<ServerInfo> getParserForType() {
      return PARSER;
    }

    public Wenhua.ServerInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PcInfoListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PcInfoList)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    java.util.List<Wenhua.PcInfo> 
        getInfosList();
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    Wenhua.PcInfo getInfos(int index);
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    int getInfosCount();
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    java.util.List<? extends Wenhua.PcInfoOrBuilder> 
        getInfosOrBuilderList();
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    Wenhua.PcInfoOrBuilder getInfosOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code PcInfoList}
   */
  public  static final class PcInfoList extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PcInfoList)
      PcInfoListOrBuilder {
    // Use PcInfoList.newBuilder() to construct.
    private PcInfoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PcInfoList() {
      infos_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private PcInfoList(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                infos_ = new java.util.ArrayList<Wenhua.PcInfo>();
                mutable_bitField0_ |= 0x00000001;
              }
              infos_.add(
                  input.readMessage(Wenhua.PcInfo.parser(), extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = java.util.Collections.unmodifiableList(infos_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_PcInfoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_PcInfoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.PcInfoList.class, Wenhua.PcInfoList.Builder.class);
    }

    public static final int INFOS_FIELD_NUMBER = 1;
    private java.util.List<Wenhua.PcInfo> infos_;
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    public java.util.List<Wenhua.PcInfo> getInfosList() {
      return infos_;
    }
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    public java.util.List<? extends Wenhua.PcInfoOrBuilder> 
        getInfosOrBuilderList() {
      return infos_;
    }
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    public int getInfosCount() {
      return infos_.size();
    }
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    public Wenhua.PcInfo getInfos(int index) {
      return infos_.get(index);
    }
    /**
     * <code>repeated .PcInfo infos = 1;</code>
     */
    public Wenhua.PcInfoOrBuilder getInfosOrBuilder(
        int index) {
      return infos_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      for (int i = 0; i < infos_.size(); i++) {
        output.writeMessage(1, infos_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < infos_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, infos_.get(i));
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.PcInfoList)) {
        return super.equals(obj);
      }
      Wenhua.PcInfoList other = (Wenhua.PcInfoList) obj;

      boolean result = true;
      result = result && getInfosList()
          .equals(other.getInfosList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getInfosCount() > 0) {
        hash = (37 * hash) + INFOS_FIELD_NUMBER;
        hash = (53 * hash) + getInfosList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.PcInfoList parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInfoList parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInfoList parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInfoList parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInfoList parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfoList parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInfoList parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfoList parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInfoList parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfoList parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.PcInfoList prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code PcInfoList}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PcInfoList)
        Wenhua.PcInfoListOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_PcInfoList_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_PcInfoList_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.PcInfoList.class, Wenhua.PcInfoList.Builder.class);
      }

      // Construct using Wenhua.PcInfoList.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getInfosFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          infosBuilder_.clear();
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_PcInfoList_descriptor;
      }

      public Wenhua.PcInfoList getDefaultInstanceForType() {
        return Wenhua.PcInfoList.getDefaultInstance();
      }

      public Wenhua.PcInfoList build() {
        Wenhua.PcInfoList result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.PcInfoList buildPartial() {
        Wenhua.PcInfoList result = new Wenhua.PcInfoList(this);
        int from_bitField0_ = bitField0_;
        if (infosBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            infos_ = java.util.Collections.unmodifiableList(infos_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.infos_ = infos_;
        } else {
          result.infos_ = infosBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.PcInfoList) {
          return mergeFrom((Wenhua.PcInfoList)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.PcInfoList other) {
        if (other == Wenhua.PcInfoList.getDefaultInstance()) return this;
        if (infosBuilder_ == null) {
          if (!other.infos_.isEmpty()) {
            if (infos_.isEmpty()) {
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureInfosIsMutable();
              infos_.addAll(other.infos_);
            }
            onChanged();
          }
        } else {
          if (!other.infos_.isEmpty()) {
            if (infosBuilder_.isEmpty()) {
              infosBuilder_.dispose();
              infosBuilder_ = null;
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
              infosBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getInfosFieldBuilder() : null;
            } else {
              infosBuilder_.addAllMessages(other.infos_);
            }
          }
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.PcInfoList parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.PcInfoList) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<Wenhua.PcInfo> infos_ =
        java.util.Collections.emptyList();
      private void ensureInfosIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = new java.util.ArrayList<Wenhua.PcInfo>(infos_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.PcInfo, Wenhua.PcInfo.Builder, Wenhua.PcInfoOrBuilder> infosBuilder_;

      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.PcInfo> getInfosList() {
        if (infosBuilder_ == null) {
          return java.util.Collections.unmodifiableList(infos_);
        } else {
          return infosBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public int getInfosCount() {
        if (infosBuilder_ == null) {
          return infos_.size();
        } else {
          return infosBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Wenhua.PcInfo getInfos(int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);
        } else {
          return infosBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.PcInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.set(index, value);
          onChanged();
        } else {
          infosBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.PcInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.set(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder addInfos(Wenhua.PcInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(value);
          onChanged();
        } else {
          infosBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.PcInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(index, value);
          onChanged();
        } else {
          infosBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder addInfos(
          Wenhua.PcInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.PcInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder addAllInfos(
          java.lang.Iterable<? extends Wenhua.PcInfo> values) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, infos_);
          onChanged();
        } else {
          infosBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder clearInfos() {
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          infosBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Builder removeInfos(int index) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.remove(index);
          onChanged();
        } else {
          infosBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Wenhua.PcInfo.Builder getInfosBuilder(
          int index) {
        return getInfosFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Wenhua.PcInfoOrBuilder getInfosOrBuilder(
          int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);  } else {
          return infosBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public java.util.List<? extends Wenhua.PcInfoOrBuilder> 
           getInfosOrBuilderList() {
        if (infosBuilder_ != null) {
          return infosBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(infos_);
        }
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Wenhua.PcInfo.Builder addInfosBuilder() {
        return getInfosFieldBuilder().addBuilder(
            Wenhua.PcInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public Wenhua.PcInfo.Builder addInfosBuilder(
          int index) {
        return getInfosFieldBuilder().addBuilder(
            index, Wenhua.PcInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .PcInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.PcInfo.Builder> 
           getInfosBuilderList() {
        return getInfosFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.PcInfo, Wenhua.PcInfo.Builder, Wenhua.PcInfoOrBuilder> 
          getInfosFieldBuilder() {
        if (infosBuilder_ == null) {
          infosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Wenhua.PcInfo, Wenhua.PcInfo.Builder, Wenhua.PcInfoOrBuilder>(
                  infos_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          infos_ = null;
        }
        return infosBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:PcInfoList)
    }

    // @@protoc_insertion_point(class_scope:PcInfoList)
    private static final Wenhua.PcInfoList DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.PcInfoList();
    }

    public static Wenhua.PcInfoList getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PcInfoList>
        PARSER = new com.google.protobuf.AbstractParser<PcInfoList>() {
      public PcInfoList parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PcInfoList(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PcInfoList> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PcInfoList> getParserForType() {
      return PARSER;
    }

    public Wenhua.PcInfoList getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PcInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PcInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string mac = 1;</code>
     */
    java.lang.String getMac();
    /**
     * <code>string mac = 1;</code>
     */
    com.google.protobuf.ByteString
        getMacBytes();

    /**
     * <code>string ip = 2;</code>
     */
    java.lang.String getIp();
    /**
     * <code>string ip = 2;</code>
     */
    com.google.protobuf.ByteString
        getIpBytes();

    /**
     * <code>string pcname = 3;</code>
     */
    java.lang.String getPcname();
    /**
     * <code>string pcname = 3;</code>
     */
    com.google.protobuf.ByteString
        getPcnameBytes();

    /**
     * <code>int32 os = 4;</code>
     */
    int getOs();

    /**
     * <code>string windows = 5;</code>
     */
    java.lang.String getWindows();
    /**
     * <code>string windows = 5;</code>
     */
    com.google.protobuf.ByteString
        getWindowsBytes();
  }
  /**
   * Protobuf type {@code PcInfo}
   */
  public  static final class PcInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PcInfo)
      PcInfoOrBuilder {
    // Use PcInfo.newBuilder() to construct.
    private PcInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PcInfo() {
      mac_ = "";
      ip_ = "";
      pcname_ = "";
      os_ = 0;
      windows_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private PcInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              mac_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              ip_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              pcname_ = s;
              break;
            }
            case 32: {

              os_ = input.readInt32();
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              windows_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_PcInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_PcInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.PcInfo.class, Wenhua.PcInfo.Builder.class);
    }

    public static final int MAC_FIELD_NUMBER = 1;
    private volatile java.lang.Object mac_;
    /**
     * <code>string mac = 1;</code>
     */
    public java.lang.String getMac() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mac_ = s;
        return s;
      }
    }
    /**
     * <code>string mac = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMacBytes() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mac_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int IP_FIELD_NUMBER = 2;
    private volatile java.lang.Object ip_;
    /**
     * <code>string ip = 2;</code>
     */
    public java.lang.String getIp() {
      java.lang.Object ref = ip_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        ip_ = s;
        return s;
      }
    }
    /**
     * <code>string ip = 2;</code>
     */
    public com.google.protobuf.ByteString
        getIpBytes() {
      java.lang.Object ref = ip_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        ip_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int PCNAME_FIELD_NUMBER = 3;
    private volatile java.lang.Object pcname_;
    /**
     * <code>string pcname = 3;</code>
     */
    public java.lang.String getPcname() {
      java.lang.Object ref = pcname_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        pcname_ = s;
        return s;
      }
    }
    /**
     * <code>string pcname = 3;</code>
     */
    public com.google.protobuf.ByteString
        getPcnameBytes() {
      java.lang.Object ref = pcname_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        pcname_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int OS_FIELD_NUMBER = 4;
    private int os_;
    /**
     * <code>int32 os = 4;</code>
     */
    public int getOs() {
      return os_;
    }

    public static final int WINDOWS_FIELD_NUMBER = 5;
    private volatile java.lang.Object windows_;
    /**
     * <code>string windows = 5;</code>
     */
    public java.lang.String getWindows() {
      java.lang.Object ref = windows_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        windows_ = s;
        return s;
      }
    }
    /**
     * <code>string windows = 5;</code>
     */
    public com.google.protobuf.ByteString
        getWindowsBytes() {
      java.lang.Object ref = windows_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        windows_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMacBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mac_);
      }
      if (!getIpBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, ip_);
      }
      if (!getPcnameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, pcname_);
      }
      if (os_ != 0) {
        output.writeInt32(4, os_);
      }
      if (!getWindowsBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, windows_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMacBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, mac_);
      }
      if (!getIpBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, ip_);
      }
      if (!getPcnameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, pcname_);
      }
      if (os_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, os_);
      }
      if (!getWindowsBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, windows_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.PcInfo)) {
        return super.equals(obj);
      }
      Wenhua.PcInfo other = (Wenhua.PcInfo) obj;

      boolean result = true;
      result = result && getMac()
          .equals(other.getMac());
      result = result && getIp()
          .equals(other.getIp());
      result = result && getPcname()
          .equals(other.getPcname());
      result = result && (getOs()
          == other.getOs());
      result = result && getWindows()
          .equals(other.getWindows());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MAC_FIELD_NUMBER;
      hash = (53 * hash) + getMac().hashCode();
      hash = (37 * hash) + IP_FIELD_NUMBER;
      hash = (53 * hash) + getIp().hashCode();
      hash = (37 * hash) + PCNAME_FIELD_NUMBER;
      hash = (53 * hash) + getPcname().hashCode();
      hash = (37 * hash) + OS_FIELD_NUMBER;
      hash = (53 * hash) + getOs();
      hash = (37 * hash) + WINDOWS_FIELD_NUMBER;
      hash = (53 * hash) + getWindows().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.PcInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.PcInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code PcInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PcInfo)
        Wenhua.PcInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_PcInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_PcInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.PcInfo.class, Wenhua.PcInfo.Builder.class);
      }

      // Construct using Wenhua.PcInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        mac_ = "";

        ip_ = "";

        pcname_ = "";

        os_ = 0;

        windows_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_PcInfo_descriptor;
      }

      public Wenhua.PcInfo getDefaultInstanceForType() {
        return Wenhua.PcInfo.getDefaultInstance();
      }

      public Wenhua.PcInfo build() {
        Wenhua.PcInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.PcInfo buildPartial() {
        Wenhua.PcInfo result = new Wenhua.PcInfo(this);
        result.mac_ = mac_;
        result.ip_ = ip_;
        result.pcname_ = pcname_;
        result.os_ = os_;
        result.windows_ = windows_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.PcInfo) {
          return mergeFrom((Wenhua.PcInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.PcInfo other) {
        if (other == Wenhua.PcInfo.getDefaultInstance()) return this;
        if (!other.getMac().isEmpty()) {
          mac_ = other.mac_;
          onChanged();
        }
        if (!other.getIp().isEmpty()) {
          ip_ = other.ip_;
          onChanged();
        }
        if (!other.getPcname().isEmpty()) {
          pcname_ = other.pcname_;
          onChanged();
        }
        if (other.getOs() != 0) {
          setOs(other.getOs());
        }
        if (!other.getWindows().isEmpty()) {
          windows_ = other.windows_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.PcInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.PcInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object mac_ = "";
      /**
       * <code>string mac = 1;</code>
       */
      public java.lang.String getMac() {
        java.lang.Object ref = mac_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          mac_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMacBytes() {
        java.lang.Object ref = mac_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          mac_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMac(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        mac_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder clearMac() {
        
        mac_ = getDefaultInstance().getMac();
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMacBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        mac_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object ip_ = "";
      /**
       * <code>string ip = 2;</code>
       */
      public java.lang.String getIp() {
        java.lang.Object ref = ip_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          ip_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string ip = 2;</code>
       */
      public com.google.protobuf.ByteString
          getIpBytes() {
        java.lang.Object ref = ip_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          ip_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder setIp(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        ip_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder clearIp() {
        
        ip_ = getDefaultInstance().getIp();
        onChanged();
        return this;
      }
      /**
       * <code>string ip = 2;</code>
       */
      public Builder setIpBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        ip_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object pcname_ = "";
      /**
       * <code>string pcname = 3;</code>
       */
      public java.lang.String getPcname() {
        java.lang.Object ref = pcname_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          pcname_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public com.google.protobuf.ByteString
          getPcnameBytes() {
        java.lang.Object ref = pcname_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          pcname_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder setPcname(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        pcname_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder clearPcname() {
        
        pcname_ = getDefaultInstance().getPcname();
        onChanged();
        return this;
      }
      /**
       * <code>string pcname = 3;</code>
       */
      public Builder setPcnameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        pcname_ = value;
        onChanged();
        return this;
      }

      private int os_ ;
      /**
       * <code>int32 os = 4;</code>
       */
      public int getOs() {
        return os_;
      }
      /**
       * <code>int32 os = 4;</code>
       */
      public Builder setOs(int value) {
        
        os_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 os = 4;</code>
       */
      public Builder clearOs() {
        
        os_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object windows_ = "";
      /**
       * <code>string windows = 5;</code>
       */
      public java.lang.String getWindows() {
        java.lang.Object ref = windows_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          windows_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string windows = 5;</code>
       */
      public com.google.protobuf.ByteString
          getWindowsBytes() {
        java.lang.Object ref = windows_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          windows_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder setWindows(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        windows_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder clearWindows() {
        
        windows_ = getDefaultInstance().getWindows();
        onChanged();
        return this;
      }
      /**
       * <code>string windows = 5;</code>
       */
      public Builder setWindowsBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        windows_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:PcInfo)
    }

    // @@protoc_insertion_point(class_scope:PcInfo)
    private static final Wenhua.PcInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.PcInfo();
    }

    public static Wenhua.PcInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PcInfo>
        PARSER = new com.google.protobuf.AbstractParser<PcInfo>() {
      public PcInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PcInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PcInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PcInfo> getParserForType() {
      return PARSER;
    }

    public Wenhua.PcInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PcInstantInfoListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PcInstantInfoList)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    java.util.List<Wenhua.PcInstantInfo> 
        getInfosList();
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    Wenhua.PcInstantInfo getInfos(int index);
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    int getInfosCount();
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    java.util.List<? extends Wenhua.PcInstantInfoOrBuilder> 
        getInfosOrBuilderList();
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    Wenhua.PcInstantInfoOrBuilder getInfosOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code PcInstantInfoList}
   */
  public  static final class PcInstantInfoList extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PcInstantInfoList)
      PcInstantInfoListOrBuilder {
    // Use PcInstantInfoList.newBuilder() to construct.
    private PcInstantInfoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PcInstantInfoList() {
      infos_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private PcInstantInfoList(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                infos_ = new java.util.ArrayList<Wenhua.PcInstantInfo>();
                mutable_bitField0_ |= 0x00000001;
              }
              infos_.add(
                  input.readMessage(Wenhua.PcInstantInfo.parser(), extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = java.util.Collections.unmodifiableList(infos_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_PcInstantInfoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_PcInstantInfoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.PcInstantInfoList.class, Wenhua.PcInstantInfoList.Builder.class);
    }

    public static final int INFOS_FIELD_NUMBER = 1;
    private java.util.List<Wenhua.PcInstantInfo> infos_;
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    public java.util.List<Wenhua.PcInstantInfo> getInfosList() {
      return infos_;
    }
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    public java.util.List<? extends Wenhua.PcInstantInfoOrBuilder> 
        getInfosOrBuilderList() {
      return infos_;
    }
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    public int getInfosCount() {
      return infos_.size();
    }
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    public Wenhua.PcInstantInfo getInfos(int index) {
      return infos_.get(index);
    }
    /**
     * <code>repeated .PcInstantInfo infos = 1;</code>
     */
    public Wenhua.PcInstantInfoOrBuilder getInfosOrBuilder(
        int index) {
      return infos_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      for (int i = 0; i < infos_.size(); i++) {
        output.writeMessage(1, infos_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < infos_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, infos_.get(i));
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.PcInstantInfoList)) {
        return super.equals(obj);
      }
      Wenhua.PcInstantInfoList other = (Wenhua.PcInstantInfoList) obj;

      boolean result = true;
      result = result && getInfosList()
          .equals(other.getInfosList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getInfosCount() > 0) {
        hash = (37 * hash) + INFOS_FIELD_NUMBER;
        hash = (53 * hash) + getInfosList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.PcInstantInfoList parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInstantInfoList parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInstantInfoList parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInstantInfoList parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInstantInfoList parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfoList parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInstantInfoList parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfoList parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInstantInfoList parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfoList parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.PcInstantInfoList prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code PcInstantInfoList}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PcInstantInfoList)
        Wenhua.PcInstantInfoListOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_PcInstantInfoList_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_PcInstantInfoList_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.PcInstantInfoList.class, Wenhua.PcInstantInfoList.Builder.class);
      }

      // Construct using Wenhua.PcInstantInfoList.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getInfosFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          infosBuilder_.clear();
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_PcInstantInfoList_descriptor;
      }

      public Wenhua.PcInstantInfoList getDefaultInstanceForType() {
        return Wenhua.PcInstantInfoList.getDefaultInstance();
      }

      public Wenhua.PcInstantInfoList build() {
        Wenhua.PcInstantInfoList result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.PcInstantInfoList buildPartial() {
        Wenhua.PcInstantInfoList result = new Wenhua.PcInstantInfoList(this);
        int from_bitField0_ = bitField0_;
        if (infosBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            infos_ = java.util.Collections.unmodifiableList(infos_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.infos_ = infos_;
        } else {
          result.infos_ = infosBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.PcInstantInfoList) {
          return mergeFrom((Wenhua.PcInstantInfoList)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.PcInstantInfoList other) {
        if (other == Wenhua.PcInstantInfoList.getDefaultInstance()) return this;
        if (infosBuilder_ == null) {
          if (!other.infos_.isEmpty()) {
            if (infos_.isEmpty()) {
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureInfosIsMutable();
              infos_.addAll(other.infos_);
            }
            onChanged();
          }
        } else {
          if (!other.infos_.isEmpty()) {
            if (infosBuilder_.isEmpty()) {
              infosBuilder_.dispose();
              infosBuilder_ = null;
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
              infosBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getInfosFieldBuilder() : null;
            } else {
              infosBuilder_.addAllMessages(other.infos_);
            }
          }
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.PcInstantInfoList parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.PcInstantInfoList) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<Wenhua.PcInstantInfo> infos_ =
        java.util.Collections.emptyList();
      private void ensureInfosIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = new java.util.ArrayList<Wenhua.PcInstantInfo>(infos_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.PcInstantInfo, Wenhua.PcInstantInfo.Builder, Wenhua.PcInstantInfoOrBuilder> infosBuilder_;

      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.PcInstantInfo> getInfosList() {
        if (infosBuilder_ == null) {
          return java.util.Collections.unmodifiableList(infos_);
        } else {
          return infosBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public int getInfosCount() {
        if (infosBuilder_ == null) {
          return infos_.size();
        } else {
          return infosBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Wenhua.PcInstantInfo getInfos(int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);
        } else {
          return infosBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.PcInstantInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.set(index, value);
          onChanged();
        } else {
          infosBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.PcInstantInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.set(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder addInfos(Wenhua.PcInstantInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(value);
          onChanged();
        } else {
          infosBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.PcInstantInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(index, value);
          onChanged();
        } else {
          infosBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder addInfos(
          Wenhua.PcInstantInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.PcInstantInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder addAllInfos(
          java.lang.Iterable<? extends Wenhua.PcInstantInfo> values) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, infos_);
          onChanged();
        } else {
          infosBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder clearInfos() {
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          infosBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Builder removeInfos(int index) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.remove(index);
          onChanged();
        } else {
          infosBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Wenhua.PcInstantInfo.Builder getInfosBuilder(
          int index) {
        return getInfosFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Wenhua.PcInstantInfoOrBuilder getInfosOrBuilder(
          int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);  } else {
          return infosBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public java.util.List<? extends Wenhua.PcInstantInfoOrBuilder> 
           getInfosOrBuilderList() {
        if (infosBuilder_ != null) {
          return infosBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(infos_);
        }
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Wenhua.PcInstantInfo.Builder addInfosBuilder() {
        return getInfosFieldBuilder().addBuilder(
            Wenhua.PcInstantInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public Wenhua.PcInstantInfo.Builder addInfosBuilder(
          int index) {
        return getInfosFieldBuilder().addBuilder(
            index, Wenhua.PcInstantInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .PcInstantInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.PcInstantInfo.Builder> 
           getInfosBuilderList() {
        return getInfosFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.PcInstantInfo, Wenhua.PcInstantInfo.Builder, Wenhua.PcInstantInfoOrBuilder> 
          getInfosFieldBuilder() {
        if (infosBuilder_ == null) {
          infosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Wenhua.PcInstantInfo, Wenhua.PcInstantInfo.Builder, Wenhua.PcInstantInfoOrBuilder>(
                  infos_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          infos_ = null;
        }
        return infosBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:PcInstantInfoList)
    }

    // @@protoc_insertion_point(class_scope:PcInstantInfoList)
    private static final Wenhua.PcInstantInfoList DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.PcInstantInfoList();
    }

    public static Wenhua.PcInstantInfoList getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PcInstantInfoList>
        PARSER = new com.google.protobuf.AbstractParser<PcInstantInfoList>() {
      public PcInstantInfoList parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PcInstantInfoList(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PcInstantInfoList> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PcInstantInfoList> getParserForType() {
      return PARSER;
    }

    public Wenhua.PcInstantInfoList getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface PcInstantInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:PcInstantInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string mac = 1;</code>
     */
    java.lang.String getMac();
    /**
     * <code>string mac = 1;</code>
     */
    com.google.protobuf.ByteString
        getMacBytes();

    /**
     * <code>bool isPowerOn = 2;</code>
     */
    boolean getIsPowerOn();

    /**
     * <code>bool isRunWenhua = 3;</code>
     */
    boolean getIsRunWenhua();

    /**
     * <code>bool isUserLogin = 4;</code>
     */
    boolean getIsUserLogin();

    /**
     * <code>int32 wenhuaDuration = 5;</code>
     */
    int getWenhuaDuration();
  }
  /**
   * Protobuf type {@code PcInstantInfo}
   */
  public  static final class PcInstantInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:PcInstantInfo)
      PcInstantInfoOrBuilder {
    // Use PcInstantInfo.newBuilder() to construct.
    private PcInstantInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private PcInstantInfo() {
      mac_ = "";
      isPowerOn_ = false;
      isRunWenhua_ = false;
      isUserLogin_ = false;
      wenhuaDuration_ = 0;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private PcInstantInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              mac_ = s;
              break;
            }
            case 16: {

              isPowerOn_ = input.readBool();
              break;
            }
            case 24: {

              isRunWenhua_ = input.readBool();
              break;
            }
            case 32: {

              isUserLogin_ = input.readBool();
              break;
            }
            case 40: {

              wenhuaDuration_ = input.readInt32();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_PcInstantInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_PcInstantInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.PcInstantInfo.class, Wenhua.PcInstantInfo.Builder.class);
    }

    public static final int MAC_FIELD_NUMBER = 1;
    private volatile java.lang.Object mac_;
    /**
     * <code>string mac = 1;</code>
     */
    public java.lang.String getMac() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        mac_ = s;
        return s;
      }
    }
    /**
     * <code>string mac = 1;</code>
     */
    public com.google.protobuf.ByteString
        getMacBytes() {
      java.lang.Object ref = mac_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        mac_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int ISPOWERON_FIELD_NUMBER = 2;
    private boolean isPowerOn_;
    /**
     * <code>bool isPowerOn = 2;</code>
     */
    public boolean getIsPowerOn() {
      return isPowerOn_;
    }

    public static final int ISRUNWENHUA_FIELD_NUMBER = 3;
    private boolean isRunWenhua_;
    /**
     * <code>bool isRunWenhua = 3;</code>
     */
    public boolean getIsRunWenhua() {
      return isRunWenhua_;
    }

    public static final int ISUSERLOGIN_FIELD_NUMBER = 4;
    private boolean isUserLogin_;
    /**
     * <code>bool isUserLogin = 4;</code>
     */
    public boolean getIsUserLogin() {
      return isUserLogin_;
    }

    public static final int WENHUADURATION_FIELD_NUMBER = 5;
    private int wenhuaDuration_;
    /**
     * <code>int32 wenhuaDuration = 5;</code>
     */
    public int getWenhuaDuration() {
      return wenhuaDuration_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getMacBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, mac_);
      }
      if (isPowerOn_ != false) {
        output.writeBool(2, isPowerOn_);
      }
      if (isRunWenhua_ != false) {
        output.writeBool(3, isRunWenhua_);
      }
      if (isUserLogin_ != false) {
        output.writeBool(4, isUserLogin_);
      }
      if (wenhuaDuration_ != 0) {
        output.writeInt32(5, wenhuaDuration_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getMacBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, mac_);
      }
      if (isPowerOn_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(2, isPowerOn_);
      }
      if (isRunWenhua_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(3, isRunWenhua_);
      }
      if (isUserLogin_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(4, isUserLogin_);
      }
      if (wenhuaDuration_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, wenhuaDuration_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.PcInstantInfo)) {
        return super.equals(obj);
      }
      Wenhua.PcInstantInfo other = (Wenhua.PcInstantInfo) obj;

      boolean result = true;
      result = result && getMac()
          .equals(other.getMac());
      result = result && (getIsPowerOn()
          == other.getIsPowerOn());
      result = result && (getIsRunWenhua()
          == other.getIsRunWenhua());
      result = result && (getIsUserLogin()
          == other.getIsUserLogin());
      result = result && (getWenhuaDuration()
          == other.getWenhuaDuration());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + MAC_FIELD_NUMBER;
      hash = (53 * hash) + getMac().hashCode();
      hash = (37 * hash) + ISPOWERON_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsPowerOn());
      hash = (37 * hash) + ISRUNWENHUA_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsRunWenhua());
      hash = (37 * hash) + ISUSERLOGIN_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getIsUserLogin());
      hash = (37 * hash) + WENHUADURATION_FIELD_NUMBER;
      hash = (53 * hash) + getWenhuaDuration();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.PcInstantInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInstantInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInstantInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.PcInstantInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.PcInstantInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInstantInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.PcInstantInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.PcInstantInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.PcInstantInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code PcInstantInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:PcInstantInfo)
        Wenhua.PcInstantInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_PcInstantInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_PcInstantInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.PcInstantInfo.class, Wenhua.PcInstantInfo.Builder.class);
      }

      // Construct using Wenhua.PcInstantInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        mac_ = "";

        isPowerOn_ = false;

        isRunWenhua_ = false;

        isUserLogin_ = false;

        wenhuaDuration_ = 0;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_PcInstantInfo_descriptor;
      }

      public Wenhua.PcInstantInfo getDefaultInstanceForType() {
        return Wenhua.PcInstantInfo.getDefaultInstance();
      }

      public Wenhua.PcInstantInfo build() {
        Wenhua.PcInstantInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.PcInstantInfo buildPartial() {
        Wenhua.PcInstantInfo result = new Wenhua.PcInstantInfo(this);
        result.mac_ = mac_;
        result.isPowerOn_ = isPowerOn_;
        result.isRunWenhua_ = isRunWenhua_;
        result.isUserLogin_ = isUserLogin_;
        result.wenhuaDuration_ = wenhuaDuration_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.PcInstantInfo) {
          return mergeFrom((Wenhua.PcInstantInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.PcInstantInfo other) {
        if (other == Wenhua.PcInstantInfo.getDefaultInstance()) return this;
        if (!other.getMac().isEmpty()) {
          mac_ = other.mac_;
          onChanged();
        }
        if (other.getIsPowerOn() != false) {
          setIsPowerOn(other.getIsPowerOn());
        }
        if (other.getIsRunWenhua() != false) {
          setIsRunWenhua(other.getIsRunWenhua());
        }
        if (other.getIsUserLogin() != false) {
          setIsUserLogin(other.getIsUserLogin());
        }
        if (other.getWenhuaDuration() != 0) {
          setWenhuaDuration(other.getWenhuaDuration());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.PcInstantInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.PcInstantInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object mac_ = "";
      /**
       * <code>string mac = 1;</code>
       */
      public java.lang.String getMac() {
        java.lang.Object ref = mac_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          mac_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public com.google.protobuf.ByteString
          getMacBytes() {
        java.lang.Object ref = mac_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          mac_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMac(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        mac_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder clearMac() {
        
        mac_ = getDefaultInstance().getMac();
        onChanged();
        return this;
      }
      /**
       * <code>string mac = 1;</code>
       */
      public Builder setMacBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        mac_ = value;
        onChanged();
        return this;
      }

      private boolean isPowerOn_ ;
      /**
       * <code>bool isPowerOn = 2;</code>
       */
      public boolean getIsPowerOn() {
        return isPowerOn_;
      }
      /**
       * <code>bool isPowerOn = 2;</code>
       */
      public Builder setIsPowerOn(boolean value) {
        
        isPowerOn_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isPowerOn = 2;</code>
       */
      public Builder clearIsPowerOn() {
        
        isPowerOn_ = false;
        onChanged();
        return this;
      }

      private boolean isRunWenhua_ ;
      /**
       * <code>bool isRunWenhua = 3;</code>
       */
      public boolean getIsRunWenhua() {
        return isRunWenhua_;
      }
      /**
       * <code>bool isRunWenhua = 3;</code>
       */
      public Builder setIsRunWenhua(boolean value) {
        
        isRunWenhua_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isRunWenhua = 3;</code>
       */
      public Builder clearIsRunWenhua() {
        
        isRunWenhua_ = false;
        onChanged();
        return this;
      }

      private boolean isUserLogin_ ;
      /**
       * <code>bool isUserLogin = 4;</code>
       */
      public boolean getIsUserLogin() {
        return isUserLogin_;
      }
      /**
       * <code>bool isUserLogin = 4;</code>
       */
      public Builder setIsUserLogin(boolean value) {
        
        isUserLogin_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool isUserLogin = 4;</code>
       */
      public Builder clearIsUserLogin() {
        
        isUserLogin_ = false;
        onChanged();
        return this;
      }

      private int wenhuaDuration_ ;
      /**
       * <code>int32 wenhuaDuration = 5;</code>
       */
      public int getWenhuaDuration() {
        return wenhuaDuration_;
      }
      /**
       * <code>int32 wenhuaDuration = 5;</code>
       */
      public Builder setWenhuaDuration(int value) {
        
        wenhuaDuration_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 wenhuaDuration = 5;</code>
       */
      public Builder clearWenhuaDuration() {
        
        wenhuaDuration_ = 0;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:PcInstantInfo)
    }

    // @@protoc_insertion_point(class_scope:PcInstantInfo)
    private static final Wenhua.PcInstantInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.PcInstantInfo();
    }

    public static Wenhua.PcInstantInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<PcInstantInfo>
        PARSER = new com.google.protobuf.AbstractParser<PcInstantInfo>() {
      public PcInstantInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new PcInstantInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<PcInstantInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<PcInstantInfo> getParserForType() {
      return PARSER;
    }

    public Wenhua.PcInstantInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface SoftwareVersionOrBuilder extends
      // @@protoc_insertion_point(interface_extends:SoftwareVersion)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>string serverVersion = 1;</code>
     */
    java.lang.String getServerVersion();
    /**
     * <code>string serverVersion = 1;</code>
     */
    com.google.protobuf.ByteString
        getServerVersionBytes();

    /**
     * <code>string clientVersion = 2;</code>
     */
    java.lang.String getClientVersion();
    /**
     * <code>string clientVersion = 2;</code>
     */
    com.google.protobuf.ByteString
        getClientVersionBytes();
  }
  /**
   * Protobuf type {@code SoftwareVersion}
   */
  public  static final class SoftwareVersion extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:SoftwareVersion)
      SoftwareVersionOrBuilder {
    // Use SoftwareVersion.newBuilder() to construct.
    private SoftwareVersion(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private SoftwareVersion() {
      serverVersion_ = "";
      clientVersion_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private SoftwareVersion(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              java.lang.String s = input.readStringRequireUtf8();

              serverVersion_ = s;
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              clientVersion_ = s;
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_SoftwareVersion_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_SoftwareVersion_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.SoftwareVersion.class, Wenhua.SoftwareVersion.Builder.class);
    }

    public static final int SERVERVERSION_FIELD_NUMBER = 1;
    private volatile java.lang.Object serverVersion_;
    /**
     * <code>string serverVersion = 1;</code>
     */
    public java.lang.String getServerVersion() {
      java.lang.Object ref = serverVersion_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        serverVersion_ = s;
        return s;
      }
    }
    /**
     * <code>string serverVersion = 1;</code>
     */
    public com.google.protobuf.ByteString
        getServerVersionBytes() {
      java.lang.Object ref = serverVersion_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        serverVersion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CLIENTVERSION_FIELD_NUMBER = 2;
    private volatile java.lang.Object clientVersion_;
    /**
     * <code>string clientVersion = 2;</code>
     */
    public java.lang.String getClientVersion() {
      java.lang.Object ref = clientVersion_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        clientVersion_ = s;
        return s;
      }
    }
    /**
     * <code>string clientVersion = 2;</code>
     */
    public com.google.protobuf.ByteString
        getClientVersionBytes() {
      java.lang.Object ref = clientVersion_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        clientVersion_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (!getServerVersionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 1, serverVersion_);
      }
      if (!getClientVersionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, clientVersion_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (!getServerVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(1, serverVersion_);
      }
      if (!getClientVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, clientVersion_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.SoftwareVersion)) {
        return super.equals(obj);
      }
      Wenhua.SoftwareVersion other = (Wenhua.SoftwareVersion) obj;

      boolean result = true;
      result = result && getServerVersion()
          .equals(other.getServerVersion());
      result = result && getClientVersion()
          .equals(other.getClientVersion());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + SERVERVERSION_FIELD_NUMBER;
      hash = (53 * hash) + getServerVersion().hashCode();
      hash = (37 * hash) + CLIENTVERSION_FIELD_NUMBER;
      hash = (53 * hash) + getClientVersion().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.SoftwareVersion parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.SoftwareVersion parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.SoftwareVersion parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.SoftwareVersion parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.SoftwareVersion parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.SoftwareVersion parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.SoftwareVersion parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.SoftwareVersion parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.SoftwareVersion parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.SoftwareVersion parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.SoftwareVersion prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code SoftwareVersion}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:SoftwareVersion)
        Wenhua.SoftwareVersionOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_SoftwareVersion_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_SoftwareVersion_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.SoftwareVersion.class, Wenhua.SoftwareVersion.Builder.class);
      }

      // Construct using Wenhua.SoftwareVersion.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        serverVersion_ = "";

        clientVersion_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_SoftwareVersion_descriptor;
      }

      public Wenhua.SoftwareVersion getDefaultInstanceForType() {
        return Wenhua.SoftwareVersion.getDefaultInstance();
      }

      public Wenhua.SoftwareVersion build() {
        Wenhua.SoftwareVersion result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.SoftwareVersion buildPartial() {
        Wenhua.SoftwareVersion result = new Wenhua.SoftwareVersion(this);
        result.serverVersion_ = serverVersion_;
        result.clientVersion_ = clientVersion_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.SoftwareVersion) {
          return mergeFrom((Wenhua.SoftwareVersion)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.SoftwareVersion other) {
        if (other == Wenhua.SoftwareVersion.getDefaultInstance()) return this;
        if (!other.getServerVersion().isEmpty()) {
          serverVersion_ = other.serverVersion_;
          onChanged();
        }
        if (!other.getClientVersion().isEmpty()) {
          clientVersion_ = other.clientVersion_;
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.SoftwareVersion parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.SoftwareVersion) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private java.lang.Object serverVersion_ = "";
      /**
       * <code>string serverVersion = 1;</code>
       */
      public java.lang.String getServerVersion() {
        java.lang.Object ref = serverVersion_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          serverVersion_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string serverVersion = 1;</code>
       */
      public com.google.protobuf.ByteString
          getServerVersionBytes() {
        java.lang.Object ref = serverVersion_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          serverVersion_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string serverVersion = 1;</code>
       */
      public Builder setServerVersion(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        serverVersion_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string serverVersion = 1;</code>
       */
      public Builder clearServerVersion() {
        
        serverVersion_ = getDefaultInstance().getServerVersion();
        onChanged();
        return this;
      }
      /**
       * <code>string serverVersion = 1;</code>
       */
      public Builder setServerVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        serverVersion_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object clientVersion_ = "";
      /**
       * <code>string clientVersion = 2;</code>
       */
      public java.lang.String getClientVersion() {
        java.lang.Object ref = clientVersion_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          clientVersion_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string clientVersion = 2;</code>
       */
      public com.google.protobuf.ByteString
          getClientVersionBytes() {
        java.lang.Object ref = clientVersion_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          clientVersion_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string clientVersion = 2;</code>
       */
      public Builder setClientVersion(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        clientVersion_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string clientVersion = 2;</code>
       */
      public Builder clearClientVersion() {
        
        clientVersion_ = getDefaultInstance().getClientVersion();
        onChanged();
        return this;
      }
      /**
       * <code>string clientVersion = 2;</code>
       */
      public Builder setClientVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        clientVersion_ = value;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:SoftwareVersion)
    }

    // @@protoc_insertion_point(class_scope:SoftwareVersion)
    private static final Wenhua.SoftwareVersion DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.SoftwareVersion();
    }

    public static Wenhua.SoftwareVersion getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<SoftwareVersion>
        PARSER = new com.google.protobuf.AbstractParser<SoftwareVersion>() {
      public SoftwareVersion parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new SoftwareVersion(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<SoftwareVersion> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<SoftwareVersion> getParserForType() {
      return PARSER;
    }

    public Wenhua.SoftwareVersion getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface FileInfoListOrBuilder extends
      // @@protoc_insertion_point(interface_extends:FileInfoList)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    java.util.List<Wenhua.FileInfo> 
        getInfosList();
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    Wenhua.FileInfo getInfos(int index);
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    int getInfosCount();
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    java.util.List<? extends Wenhua.FileInfoOrBuilder> 
        getInfosOrBuilderList();
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    Wenhua.FileInfoOrBuilder getInfosOrBuilder(
        int index);

    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    java.util.List<Wenhua.FileBar> 
        getFileBarsList();
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    Wenhua.FileBar getFileBars(int index);
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    int getFileBarsCount();
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    java.util.List<? extends Wenhua.FileBarOrBuilder> 
        getFileBarsOrBuilderList();
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    Wenhua.FileBarOrBuilder getFileBarsOrBuilder(
        int index);
  }
  /**
   * Protobuf type {@code FileInfoList}
   */
  public  static final class FileInfoList extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:FileInfoList)
      FileInfoListOrBuilder {
    // Use FileInfoList.newBuilder() to construct.
    private FileInfoList(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private FileInfoList() {
      infos_ = java.util.Collections.emptyList();
      fileBars_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private FileInfoList(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 10: {
              if (!((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
                infos_ = new java.util.ArrayList<Wenhua.FileInfo>();
                mutable_bitField0_ |= 0x00000001;
              }
              infos_.add(
                  input.readMessage(Wenhua.FileInfo.parser(), extensionRegistry));
              break;
            }
            case 18: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                fileBars_ = new java.util.ArrayList<Wenhua.FileBar>();
                mutable_bitField0_ |= 0x00000002;
              }
              fileBars_.add(
                  input.readMessage(Wenhua.FileBar.parser(), extensionRegistry));
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = java.util.Collections.unmodifiableList(infos_);
        }
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          fileBars_ = java.util.Collections.unmodifiableList(fileBars_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_FileInfoList_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_FileInfoList_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.FileInfoList.class, Wenhua.FileInfoList.Builder.class);
    }

    public static final int INFOS_FIELD_NUMBER = 1;
    private java.util.List<Wenhua.FileInfo> infos_;
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    public java.util.List<Wenhua.FileInfo> getInfosList() {
      return infos_;
    }
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    public java.util.List<? extends Wenhua.FileInfoOrBuilder> 
        getInfosOrBuilderList() {
      return infos_;
    }
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    public int getInfosCount() {
      return infos_.size();
    }
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    public Wenhua.FileInfo getInfos(int index) {
      return infos_.get(index);
    }
    /**
     * <code>repeated .FileInfo infos = 1;</code>
     */
    public Wenhua.FileInfoOrBuilder getInfosOrBuilder(
        int index) {
      return infos_.get(index);
    }

    public static final int FILEBARS_FIELD_NUMBER = 2;
    private java.util.List<Wenhua.FileBar> fileBars_;
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    public java.util.List<Wenhua.FileBar> getFileBarsList() {
      return fileBars_;
    }
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    public java.util.List<? extends Wenhua.FileBarOrBuilder> 
        getFileBarsOrBuilderList() {
      return fileBars_;
    }
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    public int getFileBarsCount() {
      return fileBars_.size();
    }
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    public Wenhua.FileBar getFileBars(int index) {
      return fileBars_.get(index);
    }
    /**
     * <code>repeated .FileBar fileBars = 2;</code>
     */
    public Wenhua.FileBarOrBuilder getFileBarsOrBuilder(
        int index) {
      return fileBars_.get(index);
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      for (int i = 0; i < infos_.size(); i++) {
        output.writeMessage(1, infos_.get(i));
      }
      for (int i = 0; i < fileBars_.size(); i++) {
        output.writeMessage(2, fileBars_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      for (int i = 0; i < infos_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(1, infos_.get(i));
      }
      for (int i = 0; i < fileBars_.size(); i++) {
        size += com.google.protobuf.CodedOutputStream
          .computeMessageSize(2, fileBars_.get(i));
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.FileInfoList)) {
        return super.equals(obj);
      }
      Wenhua.FileInfoList other = (Wenhua.FileInfoList) obj;

      boolean result = true;
      result = result && getInfosList()
          .equals(other.getInfosList());
      result = result && getFileBarsList()
          .equals(other.getFileBarsList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      if (getInfosCount() > 0) {
        hash = (37 * hash) + INFOS_FIELD_NUMBER;
        hash = (53 * hash) + getInfosList().hashCode();
      }
      if (getFileBarsCount() > 0) {
        hash = (37 * hash) + FILEBARS_FIELD_NUMBER;
        hash = (53 * hash) + getFileBarsList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.FileInfoList parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileInfoList parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileInfoList parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileInfoList parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileInfoList parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfoList parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileInfoList parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfoList parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileInfoList parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfoList parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.FileInfoList prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code FileInfoList}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:FileInfoList)
        Wenhua.FileInfoListOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_FileInfoList_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_FileInfoList_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.FileInfoList.class, Wenhua.FileInfoList.Builder.class);
      }

      // Construct using Wenhua.FileInfoList.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
          getInfosFieldBuilder();
          getFileBarsFieldBuilder();
        }
      }
      public Builder clear() {
        super.clear();
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
        } else {
          infosBuilder_.clear();
        }
        if (fileBarsBuilder_ == null) {
          fileBars_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
        } else {
          fileBarsBuilder_.clear();
        }
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_FileInfoList_descriptor;
      }

      public Wenhua.FileInfoList getDefaultInstanceForType() {
        return Wenhua.FileInfoList.getDefaultInstance();
      }

      public Wenhua.FileInfoList build() {
        Wenhua.FileInfoList result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.FileInfoList buildPartial() {
        Wenhua.FileInfoList result = new Wenhua.FileInfoList(this);
        int from_bitField0_ = bitField0_;
        if (infosBuilder_ == null) {
          if (((bitField0_ & 0x00000001) == 0x00000001)) {
            infos_ = java.util.Collections.unmodifiableList(infos_);
            bitField0_ = (bitField0_ & ~0x00000001);
          }
          result.infos_ = infos_;
        } else {
          result.infos_ = infosBuilder_.build();
        }
        if (fileBarsBuilder_ == null) {
          if (((bitField0_ & 0x00000002) == 0x00000002)) {
            fileBars_ = java.util.Collections.unmodifiableList(fileBars_);
            bitField0_ = (bitField0_ & ~0x00000002);
          }
          result.fileBars_ = fileBars_;
        } else {
          result.fileBars_ = fileBarsBuilder_.build();
        }
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.FileInfoList) {
          return mergeFrom((Wenhua.FileInfoList)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.FileInfoList other) {
        if (other == Wenhua.FileInfoList.getDefaultInstance()) return this;
        if (infosBuilder_ == null) {
          if (!other.infos_.isEmpty()) {
            if (infos_.isEmpty()) {
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
            } else {
              ensureInfosIsMutable();
              infos_.addAll(other.infos_);
            }
            onChanged();
          }
        } else {
          if (!other.infos_.isEmpty()) {
            if (infosBuilder_.isEmpty()) {
              infosBuilder_.dispose();
              infosBuilder_ = null;
              infos_ = other.infos_;
              bitField0_ = (bitField0_ & ~0x00000001);
              infosBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getInfosFieldBuilder() : null;
            } else {
              infosBuilder_.addAllMessages(other.infos_);
            }
          }
        }
        if (fileBarsBuilder_ == null) {
          if (!other.fileBars_.isEmpty()) {
            if (fileBars_.isEmpty()) {
              fileBars_ = other.fileBars_;
              bitField0_ = (bitField0_ & ~0x00000002);
            } else {
              ensureFileBarsIsMutable();
              fileBars_.addAll(other.fileBars_);
            }
            onChanged();
          }
        } else {
          if (!other.fileBars_.isEmpty()) {
            if (fileBarsBuilder_.isEmpty()) {
              fileBarsBuilder_.dispose();
              fileBarsBuilder_ = null;
              fileBars_ = other.fileBars_;
              bitField0_ = (bitField0_ & ~0x00000002);
              fileBarsBuilder_ = 
                com.google.protobuf.GeneratedMessageV3.alwaysUseFieldBuilders ?
                   getFileBarsFieldBuilder() : null;
            } else {
              fileBarsBuilder_.addAllMessages(other.fileBars_);
            }
          }
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.FileInfoList parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.FileInfoList) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private java.util.List<Wenhua.FileInfo> infos_ =
        java.util.Collections.emptyList();
      private void ensureInfosIsMutable() {
        if (!((bitField0_ & 0x00000001) == 0x00000001)) {
          infos_ = new java.util.ArrayList<Wenhua.FileInfo>(infos_);
          bitField0_ |= 0x00000001;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.FileInfo, Wenhua.FileInfo.Builder, Wenhua.FileInfoOrBuilder> infosBuilder_;

      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.FileInfo> getInfosList() {
        if (infosBuilder_ == null) {
          return java.util.Collections.unmodifiableList(infos_);
        } else {
          return infosBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public int getInfosCount() {
        if (infosBuilder_ == null) {
          return infos_.size();
        } else {
          return infosBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Wenhua.FileInfo getInfos(int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);
        } else {
          return infosBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.FileInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.set(index, value);
          onChanged();
        } else {
          infosBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder setInfos(
          int index, Wenhua.FileInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.set(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder addInfos(Wenhua.FileInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(value);
          onChanged();
        } else {
          infosBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.FileInfo value) {
        if (infosBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureInfosIsMutable();
          infos_.add(index, value);
          onChanged();
        } else {
          infosBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder addInfos(
          Wenhua.FileInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder addInfos(
          int index, Wenhua.FileInfo.Builder builderForValue) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.add(index, builderForValue.build());
          onChanged();
        } else {
          infosBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder addAllInfos(
          java.lang.Iterable<? extends Wenhua.FileInfo> values) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, infos_);
          onChanged();
        } else {
          infosBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder clearInfos() {
        if (infosBuilder_ == null) {
          infos_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000001);
          onChanged();
        } else {
          infosBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Builder removeInfos(int index) {
        if (infosBuilder_ == null) {
          ensureInfosIsMutable();
          infos_.remove(index);
          onChanged();
        } else {
          infosBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Wenhua.FileInfo.Builder getInfosBuilder(
          int index) {
        return getInfosFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Wenhua.FileInfoOrBuilder getInfosOrBuilder(
          int index) {
        if (infosBuilder_ == null) {
          return infos_.get(index);  } else {
          return infosBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public java.util.List<? extends Wenhua.FileInfoOrBuilder> 
           getInfosOrBuilderList() {
        if (infosBuilder_ != null) {
          return infosBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(infos_);
        }
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Wenhua.FileInfo.Builder addInfosBuilder() {
        return getInfosFieldBuilder().addBuilder(
            Wenhua.FileInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public Wenhua.FileInfo.Builder addInfosBuilder(
          int index) {
        return getInfosFieldBuilder().addBuilder(
            index, Wenhua.FileInfo.getDefaultInstance());
      }
      /**
       * <code>repeated .FileInfo infos = 1;</code>
       */
      public java.util.List<Wenhua.FileInfo.Builder> 
           getInfosBuilderList() {
        return getInfosFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.FileInfo, Wenhua.FileInfo.Builder, Wenhua.FileInfoOrBuilder> 
          getInfosFieldBuilder() {
        if (infosBuilder_ == null) {
          infosBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Wenhua.FileInfo, Wenhua.FileInfo.Builder, Wenhua.FileInfoOrBuilder>(
                  infos_,
                  ((bitField0_ & 0x00000001) == 0x00000001),
                  getParentForChildren(),
                  isClean());
          infos_ = null;
        }
        return infosBuilder_;
      }

      private java.util.List<Wenhua.FileBar> fileBars_ =
        java.util.Collections.emptyList();
      private void ensureFileBarsIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          fileBars_ = new java.util.ArrayList<Wenhua.FileBar>(fileBars_);
          bitField0_ |= 0x00000002;
         }
      }

      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.FileBar, Wenhua.FileBar.Builder, Wenhua.FileBarOrBuilder> fileBarsBuilder_;

      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public java.util.List<Wenhua.FileBar> getFileBarsList() {
        if (fileBarsBuilder_ == null) {
          return java.util.Collections.unmodifiableList(fileBars_);
        } else {
          return fileBarsBuilder_.getMessageList();
        }
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public int getFileBarsCount() {
        if (fileBarsBuilder_ == null) {
          return fileBars_.size();
        } else {
          return fileBarsBuilder_.getCount();
        }
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Wenhua.FileBar getFileBars(int index) {
        if (fileBarsBuilder_ == null) {
          return fileBars_.get(index);
        } else {
          return fileBarsBuilder_.getMessage(index);
        }
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder setFileBars(
          int index, Wenhua.FileBar value) {
        if (fileBarsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFileBarsIsMutable();
          fileBars_.set(index, value);
          onChanged();
        } else {
          fileBarsBuilder_.setMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder setFileBars(
          int index, Wenhua.FileBar.Builder builderForValue) {
        if (fileBarsBuilder_ == null) {
          ensureFileBarsIsMutable();
          fileBars_.set(index, builderForValue.build());
          onChanged();
        } else {
          fileBarsBuilder_.setMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder addFileBars(Wenhua.FileBar value) {
        if (fileBarsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFileBarsIsMutable();
          fileBars_.add(value);
          onChanged();
        } else {
          fileBarsBuilder_.addMessage(value);
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder addFileBars(
          int index, Wenhua.FileBar value) {
        if (fileBarsBuilder_ == null) {
          if (value == null) {
            throw new NullPointerException();
          }
          ensureFileBarsIsMutable();
          fileBars_.add(index, value);
          onChanged();
        } else {
          fileBarsBuilder_.addMessage(index, value);
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder addFileBars(
          Wenhua.FileBar.Builder builderForValue) {
        if (fileBarsBuilder_ == null) {
          ensureFileBarsIsMutable();
          fileBars_.add(builderForValue.build());
          onChanged();
        } else {
          fileBarsBuilder_.addMessage(builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder addFileBars(
          int index, Wenhua.FileBar.Builder builderForValue) {
        if (fileBarsBuilder_ == null) {
          ensureFileBarsIsMutable();
          fileBars_.add(index, builderForValue.build());
          onChanged();
        } else {
          fileBarsBuilder_.addMessage(index, builderForValue.build());
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder addAllFileBars(
          java.lang.Iterable<? extends Wenhua.FileBar> values) {
        if (fileBarsBuilder_ == null) {
          ensureFileBarsIsMutable();
          com.google.protobuf.AbstractMessageLite.Builder.addAll(
              values, fileBars_);
          onChanged();
        } else {
          fileBarsBuilder_.addAllMessages(values);
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder clearFileBars() {
        if (fileBarsBuilder_ == null) {
          fileBars_ = java.util.Collections.emptyList();
          bitField0_ = (bitField0_ & ~0x00000002);
          onChanged();
        } else {
          fileBarsBuilder_.clear();
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Builder removeFileBars(int index) {
        if (fileBarsBuilder_ == null) {
          ensureFileBarsIsMutable();
          fileBars_.remove(index);
          onChanged();
        } else {
          fileBarsBuilder_.remove(index);
        }
        return this;
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Wenhua.FileBar.Builder getFileBarsBuilder(
          int index) {
        return getFileBarsFieldBuilder().getBuilder(index);
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Wenhua.FileBarOrBuilder getFileBarsOrBuilder(
          int index) {
        if (fileBarsBuilder_ == null) {
          return fileBars_.get(index);  } else {
          return fileBarsBuilder_.getMessageOrBuilder(index);
        }
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public java.util.List<? extends Wenhua.FileBarOrBuilder> 
           getFileBarsOrBuilderList() {
        if (fileBarsBuilder_ != null) {
          return fileBarsBuilder_.getMessageOrBuilderList();
        } else {
          return java.util.Collections.unmodifiableList(fileBars_);
        }
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Wenhua.FileBar.Builder addFileBarsBuilder() {
        return getFileBarsFieldBuilder().addBuilder(
            Wenhua.FileBar.getDefaultInstance());
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public Wenhua.FileBar.Builder addFileBarsBuilder(
          int index) {
        return getFileBarsFieldBuilder().addBuilder(
            index, Wenhua.FileBar.getDefaultInstance());
      }
      /**
       * <code>repeated .FileBar fileBars = 2;</code>
       */
      public java.util.List<Wenhua.FileBar.Builder> 
           getFileBarsBuilderList() {
        return getFileBarsFieldBuilder().getBuilderList();
      }
      private com.google.protobuf.RepeatedFieldBuilderV3<
          Wenhua.FileBar, Wenhua.FileBar.Builder, Wenhua.FileBarOrBuilder> 
          getFileBarsFieldBuilder() {
        if (fileBarsBuilder_ == null) {
          fileBarsBuilder_ = new com.google.protobuf.RepeatedFieldBuilderV3<
              Wenhua.FileBar, Wenhua.FileBar.Builder, Wenhua.FileBarOrBuilder>(
                  fileBars_,
                  ((bitField0_ & 0x00000002) == 0x00000002),
                  getParentForChildren(),
                  isClean());
          fileBars_ = null;
        }
        return fileBarsBuilder_;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:FileInfoList)
    }

    // @@protoc_insertion_point(class_scope:FileInfoList)
    private static final Wenhua.FileInfoList DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.FileInfoList();
    }

    public static Wenhua.FileInfoList getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<FileInfoList>
        PARSER = new com.google.protobuf.AbstractParser<FileInfoList>() {
      public FileInfoList parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new FileInfoList(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<FileInfoList> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<FileInfoList> getParserForType() {
      return PARSER;
    }

    public Wenhua.FileInfoList getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface FileInfoOrBuilder extends
      // @@protoc_insertion_point(interface_extends:FileInfo)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 id = 1;</code>
     */
    int getId();

    /**
     * <code>string filename = 2;</code>
     */
    java.lang.String getFilename();
    /**
     * <code>string filename = 2;</code>
     */
    com.google.protobuf.ByteString
        getFilenameBytes();

    /**
     * <code>string version = 3;</code>
     */
    java.lang.String getVersion();
    /**
     * <code>string version = 3;</code>
     */
    com.google.protobuf.ByteString
        getVersionBytes();

    /**
     * <code>string md5 = 4;</code>
     */
    java.lang.String getMd5();
    /**
     * <code>string md5 = 4;</code>
     */
    com.google.protobuf.ByteString
        getMd5Bytes();

    /**
     * <code>int32 flag = 5;</code>
     */
    int getFlag();

    /**
     * <code>int32 type = 6;</code>
     */
    int getType();

    /**
     * <code>int32 action = 7;</code>
     */
    int getAction();

    /**
     * <code>bool applyAllBar = 8;</code>
     */
    boolean getApplyAllBar();
  }
  /**
   * Protobuf type {@code FileInfo}
   */
  public  static final class FileInfo extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:FileInfo)
      FileInfoOrBuilder {
    // Use FileInfo.newBuilder() to construct.
    private FileInfo(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private FileInfo() {
      id_ = 0;
      filename_ = "";
      version_ = "";
      md5_ = "";
      flag_ = 0;
      type_ = 0;
      action_ = 0;
      applyAllBar_ = false;
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private FileInfo(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              id_ = input.readInt32();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              filename_ = s;
              break;
            }
            case 26: {
              java.lang.String s = input.readStringRequireUtf8();

              version_ = s;
              break;
            }
            case 34: {
              java.lang.String s = input.readStringRequireUtf8();

              md5_ = s;
              break;
            }
            case 40: {

              flag_ = input.readInt32();
              break;
            }
            case 48: {

              type_ = input.readInt32();
              break;
            }
            case 56: {

              action_ = input.readInt32();
              break;
            }
            case 64: {

              applyAllBar_ = input.readBool();
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_FileInfo_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_FileInfo_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.FileInfo.class, Wenhua.FileInfo.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private int id_;
    /**
     * <code>int32 id = 1;</code>
     */
    public int getId() {
      return id_;
    }

    public static final int FILENAME_FIELD_NUMBER = 2;
    private volatile java.lang.Object filename_;
    /**
     * <code>string filename = 2;</code>
     */
    public java.lang.String getFilename() {
      java.lang.Object ref = filename_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        filename_ = s;
        return s;
      }
    }
    /**
     * <code>string filename = 2;</code>
     */
    public com.google.protobuf.ByteString
        getFilenameBytes() {
      java.lang.Object ref = filename_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        filename_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int VERSION_FIELD_NUMBER = 3;
    private volatile java.lang.Object version_;
    /**
     * <code>string version = 3;</code>
     */
    public java.lang.String getVersion() {
      java.lang.Object ref = version_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        version_ = s;
        return s;
      }
    }
    /**
     * <code>string version = 3;</code>
     */
    public com.google.protobuf.ByteString
        getVersionBytes() {
      java.lang.Object ref = version_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        version_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int MD5_FIELD_NUMBER = 4;
    private volatile java.lang.Object md5_;
    /**
     * <code>string md5 = 4;</code>
     */
    public java.lang.String getMd5() {
      java.lang.Object ref = md5_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        md5_ = s;
        return s;
      }
    }
    /**
     * <code>string md5 = 4;</code>
     */
    public com.google.protobuf.ByteString
        getMd5Bytes() {
      java.lang.Object ref = md5_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        md5_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int FLAG_FIELD_NUMBER = 5;
    private int flag_;
    /**
     * <code>int32 flag = 5;</code>
     */
    public int getFlag() {
      return flag_;
    }

    public static final int TYPE_FIELD_NUMBER = 6;
    private int type_;
    /**
     * <code>int32 type = 6;</code>
     */
    public int getType() {
      return type_;
    }

    public static final int ACTION_FIELD_NUMBER = 7;
    private int action_;
    /**
     * <code>int32 action = 7;</code>
     */
    public int getAction() {
      return action_;
    }

    public static final int APPLYALLBAR_FIELD_NUMBER = 8;
    private boolean applyAllBar_;
    /**
     * <code>bool applyAllBar = 8;</code>
     */
    public boolean getApplyAllBar() {
      return applyAllBar_;
    }

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      if (id_ != 0) {
        output.writeInt32(1, id_);
      }
      if (!getFilenameBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, filename_);
      }
      if (!getVersionBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 3, version_);
      }
      if (!getMd5Bytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 4, md5_);
      }
      if (flag_ != 0) {
        output.writeInt32(5, flag_);
      }
      if (type_ != 0) {
        output.writeInt32(6, type_);
      }
      if (action_ != 0) {
        output.writeInt32(7, action_);
      }
      if (applyAllBar_ != false) {
        output.writeBool(8, applyAllBar_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, id_);
      }
      if (!getFilenameBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, filename_);
      }
      if (!getVersionBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(3, version_);
      }
      if (!getMd5Bytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(4, md5_);
      }
      if (flag_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(5, flag_);
      }
      if (type_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(6, type_);
      }
      if (action_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(7, action_);
      }
      if (applyAllBar_ != false) {
        size += com.google.protobuf.CodedOutputStream
          .computeBoolSize(8, applyAllBar_);
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.FileInfo)) {
        return super.equals(obj);
      }
      Wenhua.FileInfo other = (Wenhua.FileInfo) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getFilename()
          .equals(other.getFilename());
      result = result && getVersion()
          .equals(other.getVersion());
      result = result && getMd5()
          .equals(other.getMd5());
      result = result && (getFlag()
          == other.getFlag());
      result = result && (getType()
          == other.getType());
      result = result && (getAction()
          == other.getAction());
      result = result && (getApplyAllBar()
          == other.getApplyAllBar());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + ID_FIELD_NUMBER;
      hash = (53 * hash) + getId();
      hash = (37 * hash) + FILENAME_FIELD_NUMBER;
      hash = (53 * hash) + getFilename().hashCode();
      hash = (37 * hash) + VERSION_FIELD_NUMBER;
      hash = (53 * hash) + getVersion().hashCode();
      hash = (37 * hash) + MD5_FIELD_NUMBER;
      hash = (53 * hash) + getMd5().hashCode();
      hash = (37 * hash) + FLAG_FIELD_NUMBER;
      hash = (53 * hash) + getFlag();
      hash = (37 * hash) + TYPE_FIELD_NUMBER;
      hash = (53 * hash) + getType();
      hash = (37 * hash) + ACTION_FIELD_NUMBER;
      hash = (53 * hash) + getAction();
      hash = (37 * hash) + APPLYALLBAR_FIELD_NUMBER;
      hash = (53 * hash) + com.google.protobuf.Internal.hashBoolean(
          getApplyAllBar());
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.FileInfo parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileInfo parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileInfo parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileInfo parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileInfo parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfo parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileInfo parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfo parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileInfo parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileInfo parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.FileInfo prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code FileInfo}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:FileInfo)
        Wenhua.FileInfoOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_FileInfo_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_FileInfo_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.FileInfo.class, Wenhua.FileInfo.Builder.class);
      }

      // Construct using Wenhua.FileInfo.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        id_ = 0;

        filename_ = "";

        version_ = "";

        md5_ = "";

        flag_ = 0;

        type_ = 0;

        action_ = 0;

        applyAllBar_ = false;

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_FileInfo_descriptor;
      }

      public Wenhua.FileInfo getDefaultInstanceForType() {
        return Wenhua.FileInfo.getDefaultInstance();
      }

      public Wenhua.FileInfo build() {
        Wenhua.FileInfo result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.FileInfo buildPartial() {
        Wenhua.FileInfo result = new Wenhua.FileInfo(this);
        result.id_ = id_;
        result.filename_ = filename_;
        result.version_ = version_;
        result.md5_ = md5_;
        result.flag_ = flag_;
        result.type_ = type_;
        result.action_ = action_;
        result.applyAllBar_ = applyAllBar_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.FileInfo) {
          return mergeFrom((Wenhua.FileInfo)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.FileInfo other) {
        if (other == Wenhua.FileInfo.getDefaultInstance()) return this;
        if (other.getId() != 0) {
          setId(other.getId());
        }
        if (!other.getFilename().isEmpty()) {
          filename_ = other.filename_;
          onChanged();
        }
        if (!other.getVersion().isEmpty()) {
          version_ = other.version_;
          onChanged();
        }
        if (!other.getMd5().isEmpty()) {
          md5_ = other.md5_;
          onChanged();
        }
        if (other.getFlag() != 0) {
          setFlag(other.getFlag());
        }
        if (other.getType() != 0) {
          setType(other.getType());
        }
        if (other.getAction() != 0) {
          setAction(other.getAction());
        }
        if (other.getApplyAllBar() != false) {
          setApplyAllBar(other.getApplyAllBar());
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.FileInfo parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.FileInfo) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private int id_ ;
      /**
       * <code>int32 id = 1;</code>
       */
      public int getId() {
        return id_;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder setId(int value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object filename_ = "";
      /**
       * <code>string filename = 2;</code>
       */
      public java.lang.String getFilename() {
        java.lang.Object ref = filename_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          filename_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string filename = 2;</code>
       */
      public com.google.protobuf.ByteString
          getFilenameBytes() {
        java.lang.Object ref = filename_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          filename_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string filename = 2;</code>
       */
      public Builder setFilename(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        filename_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string filename = 2;</code>
       */
      public Builder clearFilename() {
        
        filename_ = getDefaultInstance().getFilename();
        onChanged();
        return this;
      }
      /**
       * <code>string filename = 2;</code>
       */
      public Builder setFilenameBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        filename_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object version_ = "";
      /**
       * <code>string version = 3;</code>
       */
      public java.lang.String getVersion() {
        java.lang.Object ref = version_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          version_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string version = 3;</code>
       */
      public com.google.protobuf.ByteString
          getVersionBytes() {
        java.lang.Object ref = version_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          version_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string version = 3;</code>
       */
      public Builder setVersion(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        version_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string version = 3;</code>
       */
      public Builder clearVersion() {
        
        version_ = getDefaultInstance().getVersion();
        onChanged();
        return this;
      }
      /**
       * <code>string version = 3;</code>
       */
      public Builder setVersionBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        version_ = value;
        onChanged();
        return this;
      }

      private java.lang.Object md5_ = "";
      /**
       * <code>string md5 = 4;</code>
       */
      public java.lang.String getMd5() {
        java.lang.Object ref = md5_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          md5_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string md5 = 4;</code>
       */
      public com.google.protobuf.ByteString
          getMd5Bytes() {
        java.lang.Object ref = md5_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          md5_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string md5 = 4;</code>
       */
      public Builder setMd5(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        md5_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string md5 = 4;</code>
       */
      public Builder clearMd5() {
        
        md5_ = getDefaultInstance().getMd5();
        onChanged();
        return this;
      }
      /**
       * <code>string md5 = 4;</code>
       */
      public Builder setMd5Bytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        md5_ = value;
        onChanged();
        return this;
      }

      private int flag_ ;
      /**
       * <code>int32 flag = 5;</code>
       */
      public int getFlag() {
        return flag_;
      }
      /**
       * <code>int32 flag = 5;</code>
       */
      public Builder setFlag(int value) {
        
        flag_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 flag = 5;</code>
       */
      public Builder clearFlag() {
        
        flag_ = 0;
        onChanged();
        return this;
      }

      private int type_ ;
      /**
       * <code>int32 type = 6;</code>
       */
      public int getType() {
        return type_;
      }
      /**
       * <code>int32 type = 6;</code>
       */
      public Builder setType(int value) {
        
        type_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 type = 6;</code>
       */
      public Builder clearType() {
        
        type_ = 0;
        onChanged();
        return this;
      }

      private int action_ ;
      /**
       * <code>int32 action = 7;</code>
       */
      public int getAction() {
        return action_;
      }
      /**
       * <code>int32 action = 7;</code>
       */
      public Builder setAction(int value) {
        
        action_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 action = 7;</code>
       */
      public Builder clearAction() {
        
        action_ = 0;
        onChanged();
        return this;
      }

      private boolean applyAllBar_ ;
      /**
       * <code>bool applyAllBar = 8;</code>
       */
      public boolean getApplyAllBar() {
        return applyAllBar_;
      }
      /**
       * <code>bool applyAllBar = 8;</code>
       */
      public Builder setApplyAllBar(boolean value) {
        
        applyAllBar_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bool applyAllBar = 8;</code>
       */
      public Builder clearApplyAllBar() {
        
        applyAllBar_ = false;
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:FileInfo)
    }

    // @@protoc_insertion_point(class_scope:FileInfo)
    private static final Wenhua.FileInfo DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.FileInfo();
    }

    public static Wenhua.FileInfo getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<FileInfo>
        PARSER = new com.google.protobuf.AbstractParser<FileInfo>() {
      public FileInfo parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new FileInfo(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<FileInfo> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<FileInfo> getParserForType() {
      return PARSER;
    }

    public Wenhua.FileInfo getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  public interface FileBarOrBuilder extends
      // @@protoc_insertion_point(interface_extends:FileBar)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int32 fileID = 1;</code>
     */
    int getFileID();

    /**
     * <code>repeated int32 barID = 2;</code>
     */
    java.util.List<java.lang.Integer> getBarIDList();
    /**
     * <code>repeated int32 barID = 2;</code>
     */
    int getBarIDCount();
    /**
     * <code>repeated int32 barID = 2;</code>
     */
    int getBarID(int index);
  }
  /**
   * Protobuf type {@code FileBar}
   */
  public  static final class FileBar extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:FileBar)
      FileBarOrBuilder {
    // Use FileBar.newBuilder() to construct.
    private FileBar(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private FileBar() {
      fileID_ = 0;
      barID_ = java.util.Collections.emptyList();
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private FileBar(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      this();
      int mutable_bitField0_ = 0;
      try {
        boolean done = false;
        while (!done) {
          int tag = input.readTag();
          switch (tag) {
            case 0:
              done = true;
              break;
            default: {
              if (!input.skipField(tag)) {
                done = true;
              }
              break;
            }
            case 8: {

              fileID_ = input.readInt32();
              break;
            }
            case 16: {
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
                barID_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000002;
              }
              barID_.add(input.readInt32());
              break;
            }
            case 18: {
              int length = input.readRawVarint32();
              int limit = input.pushLimit(length);
              if (!((mutable_bitField0_ & 0x00000002) == 0x00000002) && input.getBytesUntilLimit() > 0) {
                barID_ = new java.util.ArrayList<java.lang.Integer>();
                mutable_bitField0_ |= 0x00000002;
              }
              while (input.getBytesUntilLimit() > 0) {
                barID_.add(input.readInt32());
              }
              input.popLimit(limit);
              break;
            }
          }
        }
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        throw e.setUnfinishedMessage(this);
      } catch (java.io.IOException e) {
        throw new com.google.protobuf.InvalidProtocolBufferException(
            e).setUnfinishedMessage(this);
      } finally {
        if (((mutable_bitField0_ & 0x00000002) == 0x00000002)) {
          barID_ = java.util.Collections.unmodifiableList(barID_);
        }
        makeExtensionsImmutable();
      }
    }
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Wenhua.internal_static_FileBar_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Wenhua.internal_static_FileBar_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Wenhua.FileBar.class, Wenhua.FileBar.Builder.class);
    }

    private int bitField0_;
    public static final int FILEID_FIELD_NUMBER = 1;
    private int fileID_;
    /**
     * <code>int32 fileID = 1;</code>
     */
    public int getFileID() {
      return fileID_;
    }

    public static final int BARID_FIELD_NUMBER = 2;
    private java.util.List<java.lang.Integer> barID_;
    /**
     * <code>repeated int32 barID = 2;</code>
     */
    public java.util.List<java.lang.Integer>
        getBarIDList() {
      return barID_;
    }
    /**
     * <code>repeated int32 barID = 2;</code>
     */
    public int getBarIDCount() {
      return barID_.size();
    }
    /**
     * <code>repeated int32 barID = 2;</code>
     */
    public int getBarID(int index) {
      return barID_.get(index);
    }
    private int barIDMemoizedSerializedSize = -1;

    private byte memoizedIsInitialized = -1;
    public final boolean isInitialized() {
      byte isInitialized = memoizedIsInitialized;
      if (isInitialized == 1) return true;
      if (isInitialized == 0) return false;

      memoizedIsInitialized = 1;
      return true;
    }

    public void writeTo(com.google.protobuf.CodedOutputStream output)
                        throws java.io.IOException {
      getSerializedSize();
      if (fileID_ != 0) {
        output.writeInt32(1, fileID_);
      }
      if (getBarIDList().size() > 0) {
        output.writeUInt32NoTag(18);
        output.writeUInt32NoTag(barIDMemoizedSerializedSize);
      }
      for (int i = 0; i < barID_.size(); i++) {
        output.writeInt32NoTag(barID_.get(i));
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (fileID_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(1, fileID_);
      }
      {
        int dataSize = 0;
        for (int i = 0; i < barID_.size(); i++) {
          dataSize += com.google.protobuf.CodedOutputStream
            .computeInt32SizeNoTag(barID_.get(i));
        }
        size += dataSize;
        if (!getBarIDList().isEmpty()) {
          size += 1;
          size += com.google.protobuf.CodedOutputStream
              .computeInt32SizeNoTag(dataSize);
        }
        barIDMemoizedSerializedSize = dataSize;
      }
      memoizedSize = size;
      return size;
    }

    private static final long serialVersionUID = 0L;
    @java.lang.Override
    public boolean equals(final java.lang.Object obj) {
      if (obj == this) {
       return true;
      }
      if (!(obj instanceof Wenhua.FileBar)) {
        return super.equals(obj);
      }
      Wenhua.FileBar other = (Wenhua.FileBar) obj;

      boolean result = true;
      result = result && (getFileID()
          == other.getFileID());
      result = result && getBarIDList()
          .equals(other.getBarIDList());
      return result;
    }

    @java.lang.Override
    public int hashCode() {
      if (memoizedHashCode != 0) {
        return memoizedHashCode;
      }
      int hash = 41;
      hash = (19 * hash) + getDescriptor().hashCode();
      hash = (37 * hash) + FILEID_FIELD_NUMBER;
      hash = (53 * hash) + getFileID();
      if (getBarIDCount() > 0) {
        hash = (37 * hash) + BARID_FIELD_NUMBER;
        hash = (53 * hash) + getBarIDList().hashCode();
      }
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static Wenhua.FileBar parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileBar parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileBar parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static Wenhua.FileBar parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static Wenhua.FileBar parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileBar parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileBar parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static Wenhua.FileBar parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static Wenhua.FileBar parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static Wenhua.FileBar parseFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }

    public Builder newBuilderForType() { return newBuilder(); }
    public static Builder newBuilder() {
      return DEFAULT_INSTANCE.toBuilder();
    }
    public static Builder newBuilder(Wenhua.FileBar prototype) {
      return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
    }
    public Builder toBuilder() {
      return this == DEFAULT_INSTANCE
          ? new Builder() : new Builder().mergeFrom(this);
    }

    @java.lang.Override
    protected Builder newBuilderForType(
        com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
      Builder builder = new Builder(parent);
      return builder;
    }
    /**
     * Protobuf type {@code FileBar}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:FileBar)
        Wenhua.FileBarOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return Wenhua.internal_static_FileBar_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return Wenhua.internal_static_FileBar_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                Wenhua.FileBar.class, Wenhua.FileBar.Builder.class);
      }

      // Construct using Wenhua.FileBar.newBuilder()
      private Builder() {
        maybeForceBuilderInitialization();
      }

      private Builder(
          com.google.protobuf.GeneratedMessageV3.BuilderParent parent) {
        super(parent);
        maybeForceBuilderInitialization();
      }
      private void maybeForceBuilderInitialization() {
        if (com.google.protobuf.GeneratedMessageV3
                .alwaysUseFieldBuilders) {
        }
      }
      public Builder clear() {
        super.clear();
        fileID_ = 0;

        barID_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return Wenhua.internal_static_FileBar_descriptor;
      }

      public Wenhua.FileBar getDefaultInstanceForType() {
        return Wenhua.FileBar.getDefaultInstance();
      }

      public Wenhua.FileBar build() {
        Wenhua.FileBar result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public Wenhua.FileBar buildPartial() {
        Wenhua.FileBar result = new Wenhua.FileBar(this);
        int from_bitField0_ = bitField0_;
        int to_bitField0_ = 0;
        result.fileID_ = fileID_;
        if (((bitField0_ & 0x00000002) == 0x00000002)) {
          barID_ = java.util.Collections.unmodifiableList(barID_);
          bitField0_ = (bitField0_ & ~0x00000002);
        }
        result.barID_ = barID_;
        result.bitField0_ = to_bitField0_;
        onBuilt();
        return result;
      }

      public Builder clone() {
        return (Builder) super.clone();
      }
      public Builder setField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.setField(field, value);
      }
      public Builder clearField(
          com.google.protobuf.Descriptors.FieldDescriptor field) {
        return (Builder) super.clearField(field);
      }
      public Builder clearOneof(
          com.google.protobuf.Descriptors.OneofDescriptor oneof) {
        return (Builder) super.clearOneof(oneof);
      }
      public Builder setRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          int index, Object value) {
        return (Builder) super.setRepeatedField(field, index, value);
      }
      public Builder addRepeatedField(
          com.google.protobuf.Descriptors.FieldDescriptor field,
          Object value) {
        return (Builder) super.addRepeatedField(field, value);
      }
      public Builder mergeFrom(com.google.protobuf.Message other) {
        if (other instanceof Wenhua.FileBar) {
          return mergeFrom((Wenhua.FileBar)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(Wenhua.FileBar other) {
        if (other == Wenhua.FileBar.getDefaultInstance()) return this;
        if (other.getFileID() != 0) {
          setFileID(other.getFileID());
        }
        if (!other.barID_.isEmpty()) {
          if (barID_.isEmpty()) {
            barID_ = other.barID_;
            bitField0_ = (bitField0_ & ~0x00000002);
          } else {
            ensureBarIDIsMutable();
            barID_.addAll(other.barID_);
          }
          onChanged();
        }
        onChanged();
        return this;
      }

      public final boolean isInitialized() {
        return true;
      }

      public Builder mergeFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws java.io.IOException {
        Wenhua.FileBar parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (Wenhua.FileBar) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }
      private int bitField0_;

      private int fileID_ ;
      /**
       * <code>int32 fileID = 1;</code>
       */
      public int getFileID() {
        return fileID_;
      }
      /**
       * <code>int32 fileID = 1;</code>
       */
      public Builder setFileID(int value) {
        
        fileID_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 fileID = 1;</code>
       */
      public Builder clearFileID() {
        
        fileID_ = 0;
        onChanged();
        return this;
      }

      private java.util.List<java.lang.Integer> barID_ = java.util.Collections.emptyList();
      private void ensureBarIDIsMutable() {
        if (!((bitField0_ & 0x00000002) == 0x00000002)) {
          barID_ = new java.util.ArrayList<java.lang.Integer>(barID_);
          bitField0_ |= 0x00000002;
         }
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public java.util.List<java.lang.Integer>
          getBarIDList() {
        return java.util.Collections.unmodifiableList(barID_);
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public int getBarIDCount() {
        return barID_.size();
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public int getBarID(int index) {
        return barID_.get(index);
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public Builder setBarID(
          int index, int value) {
        ensureBarIDIsMutable();
        barID_.set(index, value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public Builder addBarID(int value) {
        ensureBarIDIsMutable();
        barID_.add(value);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public Builder addAllBarID(
          java.lang.Iterable<? extends java.lang.Integer> values) {
        ensureBarIDIsMutable();
        com.google.protobuf.AbstractMessageLite.Builder.addAll(
            values, barID_);
        onChanged();
        return this;
      }
      /**
       * <code>repeated int32 barID = 2;</code>
       */
      public Builder clearBarID() {
        barID_ = java.util.Collections.emptyList();
        bitField0_ = (bitField0_ & ~0x00000002);
        onChanged();
        return this;
      }
      public final Builder setUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }

      public final Builder mergeUnknownFields(
          final com.google.protobuf.UnknownFieldSet unknownFields) {
        return this;
      }


      // @@protoc_insertion_point(builder_scope:FileBar)
    }

    // @@protoc_insertion_point(class_scope:FileBar)
    private static final Wenhua.FileBar DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new Wenhua.FileBar();
    }

    public static Wenhua.FileBar getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<FileBar>
        PARSER = new com.google.protobuf.AbstractParser<FileBar>() {
      public FileBar parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new FileBar(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<FileBar> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<FileBar> getParserForType() {
      return PARSER;
    }

    public Wenhua.FileBar getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_AuthenInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_AuthenInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_BarConfig_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_BarConfig_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_ServerInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_ServerInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PcInfoList_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PcInfoList_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PcInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PcInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PcInstantInfoList_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PcInstantInfoList_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_PcInstantInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_PcInstantInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_SoftwareVersion_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_SoftwareVersion_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FileInfoList_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FileInfoList_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FileInfo_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FileInfo_fieldAccessorTable;
  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_FileBar_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_FileBar_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\014Wenhua.proto\"G\n\nAuthenInfo\022\r\n\005barID\030\001 " +
      "\001(\005\022\014\n\004when\030\002 \001(\t\022\014\n\004sign\030\003 \001(\t\022\016\n\006svrMa" +
      "c\030\004 \001(\t\"&\n\tBarConfig\022\031\n\021freqInstantPcInf" +
      "o\030\001 \001(\005\"R\n\nServerInfo\022\013\n\003mac\030\001 \001(\t\022\n\n\002ip" +
      "\030\002 \001(\t\022\016\n\006pcname\030\003 \001(\t\022\n\n\002os\030\004 \001(\005\022\017\n\007wi" +
      "ndows\030\005 \001(\t\"$\n\nPcInfoList\022\026\n\005infos\030\001 \003(\013" +
      "2\007.PcInfo\"N\n\006PcInfo\022\013\n\003mac\030\001 \001(\t\022\n\n\002ip\030\002" +
      " \001(\t\022\016\n\006pcname\030\003 \001(\t\022\n\n\002os\030\004 \001(\005\022\017\n\007wind" +
      "ows\030\005 \001(\t\"2\n\021PcInstantInfoList\022\035\n\005infos\030" +
      "\001 \003(\0132\016.PcInstantInfo\"q\n\rPcInstantInfo\022\013",
      "\n\003mac\030\001 \001(\t\022\021\n\tisPowerOn\030\002 \001(\010\022\023\n\013isRunW" +
      "enhua\030\003 \001(\010\022\023\n\013isUserLogin\030\004 \001(\010\022\026\n\016wenh" +
      "uaDuration\030\005 \001(\005\"?\n\017SoftwareVersion\022\025\n\rs" +
      "erverVersion\030\001 \001(\t\022\025\n\rclientVersion\030\002 \001(" +
      "\t\"D\n\014FileInfoList\022\030\n\005infos\030\001 \003(\0132\t.FileI" +
      "nfo\022\032\n\010fileBars\030\002 \003(\0132\010.FileBar\"\207\001\n\010File" +
      "Info\022\n\n\002id\030\001 \001(\005\022\020\n\010filename\030\002 \001(\t\022\017\n\007ve" +
      "rsion\030\003 \001(\t\022\013\n\003md5\030\004 \001(\t\022\014\n\004flag\030\005 \001(\005\022\014" +
      "\n\004type\030\006 \001(\005\022\016\n\006action\030\007 \001(\005\022\023\n\013applyAll" +
      "Bar\030\010 \001(\010\"(\n\007FileBar\022\016\n\006fileID\030\001 \001(\005\022\r\n\005",
      "barID\030\002 \003(\005b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        }, assigner);
    internal_static_AuthenInfo_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_AuthenInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_AuthenInfo_descriptor,
        new java.lang.String[] { "BarID", "When", "Sign", "SvrMac", });
    internal_static_BarConfig_descriptor =
      getDescriptor().getMessageTypes().get(1);
    internal_static_BarConfig_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_BarConfig_descriptor,
        new java.lang.String[] { "FreqInstantPcInfo", });
    internal_static_ServerInfo_descriptor =
      getDescriptor().getMessageTypes().get(2);
    internal_static_ServerInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_ServerInfo_descriptor,
        new java.lang.String[] { "Mac", "Ip", "Pcname", "Os", "Windows", });
    internal_static_PcInfoList_descriptor =
      getDescriptor().getMessageTypes().get(3);
    internal_static_PcInfoList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PcInfoList_descriptor,
        new java.lang.String[] { "Infos", });
    internal_static_PcInfo_descriptor =
      getDescriptor().getMessageTypes().get(4);
    internal_static_PcInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PcInfo_descriptor,
        new java.lang.String[] { "Mac", "Ip", "Pcname", "Os", "Windows", });
    internal_static_PcInstantInfoList_descriptor =
      getDescriptor().getMessageTypes().get(5);
    internal_static_PcInstantInfoList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PcInstantInfoList_descriptor,
        new java.lang.String[] { "Infos", });
    internal_static_PcInstantInfo_descriptor =
      getDescriptor().getMessageTypes().get(6);
    internal_static_PcInstantInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_PcInstantInfo_descriptor,
        new java.lang.String[] { "Mac", "IsPowerOn", "IsRunWenhua", "IsUserLogin", "WenhuaDuration", });
    internal_static_SoftwareVersion_descriptor =
      getDescriptor().getMessageTypes().get(7);
    internal_static_SoftwareVersion_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_SoftwareVersion_descriptor,
        new java.lang.String[] { "ServerVersion", "ClientVersion", });
    internal_static_FileInfoList_descriptor =
      getDescriptor().getMessageTypes().get(8);
    internal_static_FileInfoList_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FileInfoList_descriptor,
        new java.lang.String[] { "Infos", "FileBars", });
    internal_static_FileInfo_descriptor =
      getDescriptor().getMessageTypes().get(9);
    internal_static_FileInfo_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FileInfo_descriptor,
        new java.lang.String[] { "Id", "Filename", "Version", "Md5", "Flag", "Type", "Action", "ApplyAllBar", });
    internal_static_FileBar_descriptor =
      getDescriptor().getMessageTypes().get(10);
    internal_static_FileBar_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_FileBar_descriptor,
        new java.lang.String[] { "FileID", "BarID", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
