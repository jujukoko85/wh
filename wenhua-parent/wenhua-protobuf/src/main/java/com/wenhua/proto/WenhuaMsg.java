package com.wenhua.proto;


public final class WenhuaMsg {
  private WenhuaMsg() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  public interface MessageOrBuilder extends
      // @@protoc_insertion_point(interface_extends:Message)
      com.google.protobuf.MessageOrBuilder {

    /**
     * <code>int64 id = 1;</code>
     */
    long getId();

    /**
     * <code>string method = 2;</code>
     */
    java.lang.String getMethod();
    /**
     * <code>string method = 2;</code>
     */
    com.google.protobuf.ByteString
        getMethodBytes();

    /**
     * <code>bytes content = 3;</code>
     */
    com.google.protobuf.ByteString getContent();

    /**
     * <code>int32 exceptCode = 4;</code>
     */
    int getExceptCode();

    /**
     * <code>string exceptMsg = 5;</code>
     */
    java.lang.String getExceptMsg();
    /**
     * <code>string exceptMsg = 5;</code>
     */
    com.google.protobuf.ByteString
        getExceptMsgBytes();
  }
  /**
   * Protobuf type {@code Message}
   */
  public  static final class Message extends
      com.google.protobuf.GeneratedMessageV3 implements
      // @@protoc_insertion_point(message_implements:Message)
      MessageOrBuilder {
    // Use Message.newBuilder() to construct.
    private Message(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
      super(builder);
    }
    private Message() {
      id_ = 0L;
      method_ = "";
      content_ = com.google.protobuf.ByteString.EMPTY;
      exceptCode_ = 0;
      exceptMsg_ = "";
    }

    @java.lang.Override
    public final com.google.protobuf.UnknownFieldSet
    getUnknownFields() {
      return com.google.protobuf.UnknownFieldSet.getDefaultInstance();
    }
    private Message(
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

              id_ = input.readInt64();
              break;
            }
            case 18: {
              java.lang.String s = input.readStringRequireUtf8();

              method_ = s;
              break;
            }
            case 26: {

              content_ = input.readBytes();
              break;
            }
            case 32: {

              exceptCode_ = input.readInt32();
              break;
            }
            case 42: {
              java.lang.String s = input.readStringRequireUtf8();

              exceptMsg_ = s;
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
      return WenhuaMsg.internal_static_Message_descriptor;
    }

    protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
        internalGetFieldAccessorTable() {
      return WenhuaMsg.internal_static_Message_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              WenhuaMsg.Message.class, WenhuaMsg.Message.Builder.class);
    }

    public static final int ID_FIELD_NUMBER = 1;
    private long id_;
    /**
     * <code>int64 id = 1;</code>
     */
    public long getId() {
      return id_;
    }

    public static final int METHOD_FIELD_NUMBER = 2;
    private volatile java.lang.Object method_;
    /**
     * <code>string method = 2;</code>
     */
    public java.lang.String getMethod() {
      java.lang.Object ref = method_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        method_ = s;
        return s;
      }
    }
    /**
     * <code>string method = 2;</code>
     */
    public com.google.protobuf.ByteString
        getMethodBytes() {
      java.lang.Object ref = method_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        method_ = b;
        return b;
      } else {
        return (com.google.protobuf.ByteString) ref;
      }
    }

    public static final int CONTENT_FIELD_NUMBER = 3;
    private com.google.protobuf.ByteString content_;
    /**
     * <code>bytes content = 3;</code>
     */
    public com.google.protobuf.ByteString getContent() {
      return content_;
    }

    public static final int EXCEPTCODE_FIELD_NUMBER = 4;
    private int exceptCode_;
    /**
     * <code>int32 exceptCode = 4;</code>
     */
    public int getExceptCode() {
      return exceptCode_;
    }

    public static final int EXCEPTMSG_FIELD_NUMBER = 5;
    private volatile java.lang.Object exceptMsg_;
    /**
     * <code>string exceptMsg = 5;</code>
     */
    public java.lang.String getExceptMsg() {
      java.lang.Object ref = exceptMsg_;
      if (ref instanceof java.lang.String) {
        return (java.lang.String) ref;
      } else {
        com.google.protobuf.ByteString bs = 
            (com.google.protobuf.ByteString) ref;
        java.lang.String s = bs.toStringUtf8();
        exceptMsg_ = s;
        return s;
      }
    }
    /**
     * <code>string exceptMsg = 5;</code>
     */
    public com.google.protobuf.ByteString
        getExceptMsgBytes() {
      java.lang.Object ref = exceptMsg_;
      if (ref instanceof java.lang.String) {
        com.google.protobuf.ByteString b = 
            com.google.protobuf.ByteString.copyFromUtf8(
                (java.lang.String) ref);
        exceptMsg_ = b;
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
      if (id_ != 0L) {
        output.writeInt64(1, id_);
      }
      if (!getMethodBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 2, method_);
      }
      if (!content_.isEmpty()) {
        output.writeBytes(3, content_);
      }
      if (exceptCode_ != 0) {
        output.writeInt32(4, exceptCode_);
      }
      if (!getExceptMsgBytes().isEmpty()) {
        com.google.protobuf.GeneratedMessageV3.writeString(output, 5, exceptMsg_);
      }
    }

    public int getSerializedSize() {
      int size = memoizedSize;
      if (size != -1) return size;

      size = 0;
      if (id_ != 0L) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt64Size(1, id_);
      }
      if (!getMethodBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(2, method_);
      }
      if (!content_.isEmpty()) {
        size += com.google.protobuf.CodedOutputStream
          .computeBytesSize(3, content_);
      }
      if (exceptCode_ != 0) {
        size += com.google.protobuf.CodedOutputStream
          .computeInt32Size(4, exceptCode_);
      }
      if (!getExceptMsgBytes().isEmpty()) {
        size += com.google.protobuf.GeneratedMessageV3.computeStringSize(5, exceptMsg_);
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
      if (!(obj instanceof WenhuaMsg.Message)) {
        return super.equals(obj);
      }
      WenhuaMsg.Message other = (WenhuaMsg.Message) obj;

      boolean result = true;
      result = result && (getId()
          == other.getId());
      result = result && getMethod()
          .equals(other.getMethod());
      result = result && getContent()
          .equals(other.getContent());
      result = result && (getExceptCode()
          == other.getExceptCode());
      result = result && getExceptMsg()
          .equals(other.getExceptMsg());
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
      hash = (53 * hash) + com.google.protobuf.Internal.hashLong(
          getId());
      hash = (37 * hash) + METHOD_FIELD_NUMBER;
      hash = (53 * hash) + getMethod().hashCode();
      hash = (37 * hash) + CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getContent().hashCode();
      hash = (37 * hash) + EXCEPTCODE_FIELD_NUMBER;
      hash = (53 * hash) + getExceptCode();
      hash = (37 * hash) + EXCEPTMSG_FIELD_NUMBER;
      hash = (53 * hash) + getExceptMsg().hashCode();
      hash = (29 * hash) + unknownFields.hashCode();
      memoizedHashCode = hash;
      return hash;
    }

    public static WenhuaMsg.Message parseFrom(
        com.google.protobuf.ByteString data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static WenhuaMsg.Message parseFrom(
        com.google.protobuf.ByteString data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static WenhuaMsg.Message parseFrom(byte[] data)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data);
    }
    public static WenhuaMsg.Message parseFrom(
        byte[] data,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return PARSER.parseFrom(data, extensionRegistry);
    }
    public static WenhuaMsg.Message parseFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static WenhuaMsg.Message parseFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input, extensionRegistry);
    }
    public static WenhuaMsg.Message parseDelimitedFrom(java.io.InputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input);
    }
    public static WenhuaMsg.Message parseDelimitedFrom(
        java.io.InputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
    }
    public static WenhuaMsg.Message parseFrom(
        com.google.protobuf.CodedInputStream input)
        throws java.io.IOException {
      return com.google.protobuf.GeneratedMessageV3
          .parseWithIOException(PARSER, input);
    }
    public static WenhuaMsg.Message parseFrom(
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
    public static Builder newBuilder(WenhuaMsg.Message prototype) {
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
     * Protobuf type {@code Message}
     */
    public static final class Builder extends
        com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
        // @@protoc_insertion_point(builder_implements:Message)
        WenhuaMsg.MessageOrBuilder {
      public static final com.google.protobuf.Descriptors.Descriptor
          getDescriptor() {
        return WenhuaMsg.internal_static_Message_descriptor;
      }

      protected com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
          internalGetFieldAccessorTable() {
        return WenhuaMsg.internal_static_Message_fieldAccessorTable
            .ensureFieldAccessorsInitialized(
                WenhuaMsg.Message.class, WenhuaMsg.Message.Builder.class);
      }

      // Construct using WenhuaMsg.Message.newBuilder()
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
        id_ = 0L;

        method_ = "";

        content_ = com.google.protobuf.ByteString.EMPTY;

        exceptCode_ = 0;

        exceptMsg_ = "";

        return this;
      }

      public com.google.protobuf.Descriptors.Descriptor
          getDescriptorForType() {
        return WenhuaMsg.internal_static_Message_descriptor;
      }

      public WenhuaMsg.Message getDefaultInstanceForType() {
        return WenhuaMsg.Message.getDefaultInstance();
      }

      public WenhuaMsg.Message build() {
        WenhuaMsg.Message result = buildPartial();
        if (!result.isInitialized()) {
          throw newUninitializedMessageException(result);
        }
        return result;
      }

      public WenhuaMsg.Message buildPartial() {
        WenhuaMsg.Message result = new WenhuaMsg.Message(this);
        result.id_ = id_;
        result.method_ = method_;
        result.content_ = content_;
        result.exceptCode_ = exceptCode_;
        result.exceptMsg_ = exceptMsg_;
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
        if (other instanceof WenhuaMsg.Message) {
          return mergeFrom((WenhuaMsg.Message)other);
        } else {
          super.mergeFrom(other);
          return this;
        }
      }

      public Builder mergeFrom(WenhuaMsg.Message other) {
        if (other == WenhuaMsg.Message.getDefaultInstance()) return this;
        if (other.getId() != 0L) {
          setId(other.getId());
        }
        if (!other.getMethod().isEmpty()) {
          method_ = other.method_;
          onChanged();
        }
        if (other.getContent() != com.google.protobuf.ByteString.EMPTY) {
          setContent(other.getContent());
        }
        if (other.getExceptCode() != 0) {
          setExceptCode(other.getExceptCode());
        }
        if (!other.getExceptMsg().isEmpty()) {
          exceptMsg_ = other.exceptMsg_;
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
        WenhuaMsg.Message parsedMessage = null;
        try {
          parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
        } catch (com.google.protobuf.InvalidProtocolBufferException e) {
          parsedMessage = (WenhuaMsg.Message) e.getUnfinishedMessage();
          throw e.unwrapIOException();
        } finally {
          if (parsedMessage != null) {
            mergeFrom(parsedMessage);
          }
        }
        return this;
      }

      private long id_ ;
      /**
       * <code>int64 id = 1;</code>
       */
      public long getId() {
        return id_;
      }
      /**
       * <code>int64 id = 1;</code>
       */
      public Builder setId(long value) {
        
        id_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int64 id = 1;</code>
       */
      public Builder clearId() {
        
        id_ = 0L;
        onChanged();
        return this;
      }

      private java.lang.Object method_ = "";
      /**
       * <code>string method = 2;</code>
       */
      public java.lang.String getMethod() {
        java.lang.Object ref = method_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          method_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string method = 2;</code>
       */
      public com.google.protobuf.ByteString
          getMethodBytes() {
        java.lang.Object ref = method_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          method_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string method = 2;</code>
       */
      public Builder setMethod(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        method_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string method = 2;</code>
       */
      public Builder clearMethod() {
        
        method_ = getDefaultInstance().getMethod();
        onChanged();
        return this;
      }
      /**
       * <code>string method = 2;</code>
       */
      public Builder setMethodBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        method_ = value;
        onChanged();
        return this;
      }

      private com.google.protobuf.ByteString content_ = com.google.protobuf.ByteString.EMPTY;
      /**
       * <code>bytes content = 3;</code>
       */
      public com.google.protobuf.ByteString getContent() {
        return content_;
      }
      /**
       * <code>bytes content = 3;</code>
       */
      public Builder setContent(com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        content_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>bytes content = 3;</code>
       */
      public Builder clearContent() {
        
        content_ = getDefaultInstance().getContent();
        onChanged();
        return this;
      }

      private int exceptCode_ ;
      /**
       * <code>int32 exceptCode = 4;</code>
       */
      public int getExceptCode() {
        return exceptCode_;
      }
      /**
       * <code>int32 exceptCode = 4;</code>
       */
      public Builder setExceptCode(int value) {
        
        exceptCode_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>int32 exceptCode = 4;</code>
       */
      public Builder clearExceptCode() {
        
        exceptCode_ = 0;
        onChanged();
        return this;
      }

      private java.lang.Object exceptMsg_ = "";
      /**
       * <code>string exceptMsg = 5;</code>
       */
      public java.lang.String getExceptMsg() {
        java.lang.Object ref = exceptMsg_;
        if (!(ref instanceof java.lang.String)) {
          com.google.protobuf.ByteString bs =
              (com.google.protobuf.ByteString) ref;
          java.lang.String s = bs.toStringUtf8();
          exceptMsg_ = s;
          return s;
        } else {
          return (java.lang.String) ref;
        }
      }
      /**
       * <code>string exceptMsg = 5;</code>
       */
      public com.google.protobuf.ByteString
          getExceptMsgBytes() {
        java.lang.Object ref = exceptMsg_;
        if (ref instanceof String) {
          com.google.protobuf.ByteString b = 
              com.google.protobuf.ByteString.copyFromUtf8(
                  (java.lang.String) ref);
          exceptMsg_ = b;
          return b;
        } else {
          return (com.google.protobuf.ByteString) ref;
        }
      }
      /**
       * <code>string exceptMsg = 5;</code>
       */
      public Builder setExceptMsg(
          java.lang.String value) {
        if (value == null) {
    throw new NullPointerException();
  }
  
        exceptMsg_ = value;
        onChanged();
        return this;
      }
      /**
       * <code>string exceptMsg = 5;</code>
       */
      public Builder clearExceptMsg() {
        
        exceptMsg_ = getDefaultInstance().getExceptMsg();
        onChanged();
        return this;
      }
      /**
       * <code>string exceptMsg = 5;</code>
       */
      public Builder setExceptMsgBytes(
          com.google.protobuf.ByteString value) {
        if (value == null) {
    throw new NullPointerException();
  }
  checkByteStringIsUtf8(value);
        
        exceptMsg_ = value;
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


      // @@protoc_insertion_point(builder_scope:Message)
    }

    // @@protoc_insertion_point(class_scope:Message)
    private static final WenhuaMsg.Message DEFAULT_INSTANCE;
    static {
      DEFAULT_INSTANCE = new WenhuaMsg.Message();
    }

    public static WenhuaMsg.Message getDefaultInstance() {
      return DEFAULT_INSTANCE;
    }

    private static final com.google.protobuf.Parser<Message>
        PARSER = new com.google.protobuf.AbstractParser<Message>() {
      public Message parsePartialFrom(
          com.google.protobuf.CodedInputStream input,
          com.google.protobuf.ExtensionRegistryLite extensionRegistry)
          throws com.google.protobuf.InvalidProtocolBufferException {
          return new Message(input, extensionRegistry);
      }
    };

    public static com.google.protobuf.Parser<Message> parser() {
      return PARSER;
    }

    @java.lang.Override
    public com.google.protobuf.Parser<Message> getParserForType() {
      return PARSER;
    }

    public WenhuaMsg.Message getDefaultInstanceForType() {
      return DEFAULT_INSTANCE;
    }

  }

  private static final com.google.protobuf.Descriptors.Descriptor
    internal_static_Message_descriptor;
  private static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_Message_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n\017WenhuaMsg.proto\"]\n\007Message\022\n\n\002id\030\001 \001(\003" +
      "\022\016\n\006method\030\002 \001(\t\022\017\n\007content\030\003 \001(\014\022\022\n\nexc" +
      "eptCode\030\004 \001(\005\022\021\n\texceptMsg\030\005 \001(\tb\006proto3"
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
    internal_static_Message_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_Message_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_Message_descriptor,
        new java.lang.String[] { "Id", "Method", "Content", "ExceptCode", "ExceptMsg", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}
