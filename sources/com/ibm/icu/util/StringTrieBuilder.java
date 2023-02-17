package com.ibm.icu.util;

import java.util.ArrayList;
import java.util.HashMap;
public abstract class StringTrieBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = (!StringTrieBuilder.class.desiredAssertionStatus());
    private ValueNode lookupFinalValueNode = new ValueNode();
    private HashMap<Node, Node> nodes = new HashMap<>();
    private Node root;
    private State state = State.ADDING;
    @Deprecated
    protected StringBuilder strings = new StringBuilder();

    public enum Option {
        FAST,
        SMALL
    }

    /* access modifiers changed from: package-private */
    public enum State {
        ADDING,
        BUILDING_FAST,
        BUILDING_SMALL,
        BUILT
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int getMaxBranchLinearSubNodeLength();

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int getMaxLinearMatchLength();

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int getMinLinearMatch();

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract boolean matchNodesCanHaveValues();

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int write(int i);

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int write(int i, int i2);

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int writeDeltaTo(int i);

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int writeValueAndFinal(int i, boolean z);

    /* access modifiers changed from: protected */
    @Deprecated
    public abstract int writeValueAndType(boolean z, int i, int i2);

    @Deprecated
    protected StringTrieBuilder() {
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public void addImpl(CharSequence charSequence, int i) {
        if (this.state != State.ADDING) {
            throw new IllegalStateException("Cannot add (string, value) pairs after build().");
        } else if (charSequence.length() > 65535) {
            throw new IndexOutOfBoundsException("The maximum string length is 0xffff.");
        } else if (this.root == null) {
            this.root = createSuffixNode(charSequence, 0, i);
        } else {
            this.root = this.root.add(this, charSequence, 0, i);
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    @Deprecated
    public final void buildImpl(Option option) {
        switch (this.state) {
            case ADDING:
                if (this.root != null) {
                    if (option != Option.FAST) {
                        this.state = State.BUILDING_SMALL;
                        break;
                    } else {
                        this.state = State.BUILDING_FAST;
                        break;
                    }
                } else {
                    throw new IndexOutOfBoundsException("No (string, value) pairs were added.");
                }
            case BUILDING_FAST:
            case BUILDING_SMALL:
                throw new IllegalStateException("Builder failed and must be clear()ed.");
            case BUILT:
                return;
        }
        this.root = this.root.register(this);
        this.root.markRightEdgesFirst(-1);
        this.root.write(this);
        this.state = State.BUILT;
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private final Node registerNode(Node node) {
        if (this.state == State.BUILDING_FAST) {
            return node;
        }
        Node node2 = this.nodes.get(node);
        if (node2 != null) {
            return node2;
        }
        Node put = this.nodes.put(node, node);
        if ($assertionsDisabled || put == null) {
            return node;
        }
        throw new AssertionError();
    }

    private final ValueNode registerFinalValue(int i) {
        this.lookupFinalValueNode.setFinalValue(i);
        Node node = this.nodes.get(this.lookupFinalValueNode);
        if (node != null) {
            return (ValueNode) node;
        }
        ValueNode valueNode = new ValueNode(i);
        Node put = this.nodes.put(valueNode, valueNode);
        if ($assertionsDisabled || put == null) {
            return valueNode;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public static abstract class Node {
        protected int offset = 0;

        public abstract int hashCode();

        public abstract void write(StringTrieBuilder stringTrieBuilder);

        public boolean equals(Object obj) {
            return this == obj || getClass() == obj.getClass();
        }

        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            return this;
        }

        public Node register(StringTrieBuilder stringTrieBuilder) {
            return this;
        }

        public int markRightEdgesFirst(int i) {
            if (this.offset == 0) {
                this.offset = i;
            }
            return i;
        }

        public final void writeUnlessInsideRightEdge(int i, int i2, StringTrieBuilder stringTrieBuilder) {
            if (this.offset >= 0) {
                return;
            }
            if (this.offset < i2 || i < this.offset) {
                write(stringTrieBuilder);
            }
        }

        public final int getOffset() {
            return this.offset;
        }
    }

    /* access modifiers changed from: package-private */
    public static class ValueNode extends Node {
        static final /* synthetic */ boolean $assertionsDisabled = (!StringTrieBuilder.class.desiredAssertionStatus());
        protected boolean hasValue;
        protected int value;

        public ValueNode() {
        }

        public ValueNode(int i) {
            this.hasValue = true;
            this.value = i;
        }

        public final void setValue(int i) {
            if ($assertionsDisabled || !this.hasValue) {
                this.hasValue = true;
                this.value = i;
                return;
            }
            throw new AssertionError();
        }

        /* access modifiers changed from: private */
        /* access modifiers changed from: public */
        private void setFinalValue(int i) {
            this.hasValue = true;
            this.value = i;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            if (this.hasValue) {
                return 41383797 + this.value;
            }
            return 1118481;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            ValueNode valueNode = (ValueNode) obj;
            return this.hasValue == valueNode.hasValue && (!this.hasValue || this.value == valueNode.value);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            if (i == charSequence.length()) {
                throw new IllegalArgumentException("Duplicate string.");
            }
            ValueNode createSuffixNode = stringTrieBuilder.createSuffixNode(charSequence, i, i2);
            createSuffixNode.setValue(this.value);
            return createSuffixNode;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.offset = stringTrieBuilder.writeValueAndFinal(this.value, true);
        }
    }

    static final class IntermediateValueNode extends ValueNode {
        private Node next;

        public IntermediateValueNode(int i, Node node) {
            this.next = node;
            setValue(i);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return ((this.value + 82767594) * 37) + this.next.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return super.equals(obj) && this.next == ((IntermediateValueNode) obj).next;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int markRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = markRightEdgesFirst;
            return markRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            this.offset = stringTrieBuilder.writeValueAndFinal(this.value, false);
        }
    }

    /* access modifiers changed from: package-private */
    public static final class LinearMatchNode extends ValueNode {
        private int hash;
        private int length;
        private Node next;
        private int stringOffset;
        private CharSequence strings;

        public LinearMatchNode(CharSequence charSequence, int i, int i2, Node node) {
            this.strings = charSequence;
            this.stringOffset = i;
            this.length = i2;
            this.next = node;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return this.hash;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            LinearMatchNode linearMatchNode = (LinearMatchNode) obj;
            if (this.length != linearMatchNode.length || this.next != linearMatchNode.next) {
                return false;
            }
            int i = this.stringOffset;
            int i2 = linearMatchNode.stringOffset;
            int i3 = this.stringOffset + this.length;
            while (i < i3) {
                if (this.strings.charAt(i) != this.strings.charAt(i2)) {
                    return false;
                }
                i++;
                i2++;
            }
            return true;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: com.ibm.icu.util.StringTrieBuilder$DynamicBranchNode */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            Node node;
            LinearMatchNode linearMatchNode;
            if (i != charSequence.length()) {
                int i3 = this.stringOffset + this.length;
                int i4 = this.stringOffset;
                while (i4 < i3) {
                    if (i == charSequence.length()) {
                        int i5 = i4 - this.stringOffset;
                        LinearMatchNode linearMatchNode2 = new LinearMatchNode(this.strings, i4, this.length - i5, this.next);
                        linearMatchNode2.setValue(i2);
                        this.length = i5;
                        this.next = linearMatchNode2;
                        return this;
                    }
                    char charAt = this.strings.charAt(i4);
                    char charAt2 = charSequence.charAt(i);
                    if (charAt != charAt2) {
                        DynamicBranchNode dynamicBranchNode = new DynamicBranchNode();
                        if (i4 == this.stringOffset) {
                            if (this.hasValue) {
                                dynamicBranchNode.setValue(this.value);
                                this.value = 0;
                                this.hasValue = false;
                            }
                            this.stringOffset++;
                            this.length--;
                            node = this.length > 0 ? this : this.next;
                            linearMatchNode = dynamicBranchNode;
                        } else if (i4 == i3 - 1) {
                            this.length--;
                            node = this.next;
                            this.next = dynamicBranchNode;
                            linearMatchNode = this;
                        } else {
                            int i6 = i4 - this.stringOffset;
                            node = new LinearMatchNode(this.strings, i4 + 1, this.length - (i6 + 1), this.next);
                            this.length = i6;
                            this.next = dynamicBranchNode;
                            linearMatchNode = this;
                        }
                        ValueNode createSuffixNode = stringTrieBuilder.createSuffixNode(charSequence, i + 1, i2);
                        dynamicBranchNode.add(charAt, node);
                        dynamicBranchNode.add(charAt2, createSuffixNode);
                        return linearMatchNode;
                    }
                    i4++;
                    i++;
                }
                this.next = this.next.add(stringTrieBuilder, charSequence, i, i2);
                return this;
            } else if (this.hasValue) {
                throw new IllegalArgumentException("Duplicate string.");
            } else {
                setValue(i2);
                return this;
            }
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node register(StringTrieBuilder stringTrieBuilder) {
            Node node;
            this.next = this.next.register(stringTrieBuilder);
            int maxLinearMatchLength = stringTrieBuilder.getMaxLinearMatchLength();
            while (this.length > maxLinearMatchLength) {
                int i = (this.stringOffset + this.length) - maxLinearMatchLength;
                this.length -= maxLinearMatchLength;
                LinearMatchNode linearMatchNode = new LinearMatchNode(this.strings, i, maxLinearMatchLength, this.next);
                linearMatchNode.setHashCode();
                this.next = stringTrieBuilder.registerNode(linearMatchNode);
            }
            if (!this.hasValue || stringTrieBuilder.matchNodesCanHaveValues()) {
                setHashCode();
                node = this;
            } else {
                int i2 = this.value;
                this.value = 0;
                this.hasValue = false;
                setHashCode();
                node = new IntermediateValueNode(i2, stringTrieBuilder.registerNode(this));
            }
            return stringTrieBuilder.registerNode(node);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int markRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = markRightEdgesFirst;
            return markRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            stringTrieBuilder.write(this.stringOffset, this.length);
            this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, (stringTrieBuilder.getMinLinearMatch() + this.length) - 1);
        }

        private void setHashCode() {
            this.hash = ((this.length + 124151391) * 37) + this.next.hashCode();
            if (this.hasValue) {
                this.hash = (this.hash * 37) + this.value;
            }
            int i = this.stringOffset + this.length;
            for (int i2 = this.stringOffset; i2 < i; i2++) {
                this.hash = (this.hash * 37) + this.strings.charAt(i2);
            }
        }
    }

    static final class DynamicBranchNode extends ValueNode {
        private StringBuilder chars = new StringBuilder();
        private ArrayList<Node> equal = new ArrayList<>();

        public void add(char c, Node node) {
            int find = find(c);
            this.chars.insert(find, c);
            this.equal.add(find, node);
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public Node add(StringTrieBuilder stringTrieBuilder, CharSequence charSequence, int i, int i2) {
            if (i != charSequence.length()) {
                int i3 = i + 1;
                char charAt = charSequence.charAt(i);
                int find = find(charAt);
                if (find >= this.chars.length() || charAt != this.chars.charAt(find)) {
                    this.chars.insert(find, charAt);
                    this.equal.add(find, stringTrieBuilder.createSuffixNode(charSequence, i3, i2));
                } else {
                    this.equal.set(find, this.equal.get(find).add(stringTrieBuilder, charSequence, i3, i2));
                }
                return this;
            } else if (this.hasValue) {
                throw new IllegalArgumentException("Duplicate string.");
            } else {
                setValue(i2);
                return this;
            }
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public Node register(StringTrieBuilder stringTrieBuilder) {
            BranchHeadNode branchHeadNode = new BranchHeadNode(this.chars.length(), register(stringTrieBuilder, 0, this.chars.length()));
            Node node = branchHeadNode;
            if (this.hasValue) {
                if (stringTrieBuilder.matchNodesCanHaveValues()) {
                    branchHeadNode.setValue(this.value);
                } else {
                    node = new IntermediateValueNode(this.value, stringTrieBuilder.registerNode(branchHeadNode));
                }
            }
            return stringTrieBuilder.registerNode(node);
        }

        private Node register(StringTrieBuilder stringTrieBuilder, int i, int i2) {
            int i3 = i2 - i;
            if (i3 > stringTrieBuilder.getMaxBranchLinearSubNodeLength()) {
                int i4 = i + (i3 / 2);
                return stringTrieBuilder.registerNode(new SplitBranchNode(this.chars.charAt(i4), register(stringTrieBuilder, i, i4), register(stringTrieBuilder, i4, i2)));
            }
            ListBranchNode listBranchNode = new ListBranchNode(i3);
            do {
                char charAt = this.chars.charAt(i);
                Node node = this.equal.get(i);
                if (node.getClass() == ValueNode.class) {
                    listBranchNode.add(charAt, ((ValueNode) node).value);
                } else {
                    listBranchNode.add(charAt, node.register(stringTrieBuilder));
                }
                i++;
            } while (i < i2);
            return stringTrieBuilder.registerNode(listBranchNode);
        }

        private int find(char c) {
            int i = 0;
            int length = this.chars.length();
            while (i < length) {
                int i2 = (i + length) / 2;
                char charAt = this.chars.charAt(i2);
                if (c < charAt) {
                    length = i2;
                } else if (c == charAt) {
                    return i2;
                } else {
                    i = i2 + 1;
                }
            }
            return i;
        }
    }

    static abstract class BranchNode extends Node {
        protected int firstEdgeNumber;
        protected int hash;

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return this.hash;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class ListBranchNode extends BranchNode {
        static final /* synthetic */ boolean $assertionsDisabled = (!StringTrieBuilder.class.desiredAssertionStatus());
        private Node[] equal;
        private int length;
        private char[] units;
        private int[] values;

        public ListBranchNode(int i) {
            this.hash = 165535188 + i;
            this.equal = new Node[i];
            this.values = new int[i];
            this.units = new char[i];
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            ListBranchNode listBranchNode = (ListBranchNode) obj;
            for (int i = 0; i < this.length; i++) {
                if (!(this.units[i] == listBranchNode.units[i] && this.values[i] == listBranchNode.values[i] && this.equal[i] == listBranchNode.equal[i])) {
                    return false;
                }
            }
            return true;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.BranchNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return super.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset == 0) {
                this.firstEdgeNumber = i;
                int i2 = 0;
                int i3 = this.length;
                do {
                    i3--;
                    Node node = this.equal[i3];
                    if (node != null) {
                        i = node.markRightEdgesFirst(i - i2);
                    }
                    i2 = 1;
                } while (i3 > 0);
                this.offset = i;
            }
            return i;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            boolean z;
            int i;
            int i2 = this.length - 1;
            Node node = this.equal[i2];
            int offset = node == null ? this.firstEdgeNumber : node.getOffset();
            do {
                i2--;
                if (this.equal[i2] != null) {
                    this.equal[i2].writeUnlessInsideRightEdge(this.firstEdgeNumber, offset, stringTrieBuilder);
                    continue;
                }
            } while (i2 > 0);
            int i3 = this.length - 1;
            if (node == null) {
                stringTrieBuilder.writeValueAndFinal(this.values[i3], true);
            } else {
                node.write(stringTrieBuilder);
            }
            this.offset = stringTrieBuilder.write(this.units[i3]);
            while (true) {
                i3--;
                if (i3 >= 0) {
                    if (this.equal[i3] == null) {
                        i = this.values[i3];
                        z = true;
                    } else if ($assertionsDisabled || this.equal[i3].getOffset() > 0) {
                        i = this.offset - this.equal[i3].getOffset();
                        z = false;
                    } else {
                        throw new AssertionError();
                    }
                    stringTrieBuilder.writeValueAndFinal(i, z);
                    this.offset = stringTrieBuilder.write(this.units[i3]);
                } else {
                    return;
                }
            }
        }

        public void add(int i, int i2) {
            this.units[this.length] = (char) i;
            this.equal[this.length] = null;
            this.values[this.length] = i2;
            this.length++;
            this.hash = (((this.hash * 37) + i) * 37) + i2;
        }

        public void add(int i, Node node) {
            this.units[this.length] = (char) i;
            this.equal[this.length] = node;
            this.values[this.length] = 0;
            this.length++;
            this.hash = (((this.hash * 37) + i) * 37) + node.hashCode();
        }
    }

    /* access modifiers changed from: package-private */
    public static final class SplitBranchNode extends BranchNode {
        static final /* synthetic */ boolean $assertionsDisabled = (!StringTrieBuilder.class.desiredAssertionStatus());
        private Node greaterOrEqual;
        private Node lessThan;
        private char unit;

        public SplitBranchNode(char c, Node node, Node node2) {
            this.hash = ((((206918985 + c) * 37) + node.hashCode()) * 37) + node2.hashCode();
            this.unit = c;
            this.lessThan = node;
            this.greaterOrEqual = node2;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            SplitBranchNode splitBranchNode = (SplitBranchNode) obj;
            return this.unit == splitBranchNode.unit && this.lessThan == splitBranchNode.lessThan && this.greaterOrEqual == splitBranchNode.greaterOrEqual;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.BranchNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return super.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            this.firstEdgeNumber = i;
            int markRightEdgesFirst = this.lessThan.markRightEdgesFirst(this.greaterOrEqual.markRightEdgesFirst(i) - 1);
            this.offset = markRightEdgesFirst;
            return markRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.lessThan.writeUnlessInsideRightEdge(this.firstEdgeNumber, this.greaterOrEqual.getOffset(), stringTrieBuilder);
            this.greaterOrEqual.write(stringTrieBuilder);
            if ($assertionsDisabled || this.lessThan.getOffset() > 0) {
                stringTrieBuilder.writeDeltaTo(this.lessThan.getOffset());
                this.offset = stringTrieBuilder.write(this.unit);
                return;
            }
            throw new AssertionError();
        }
    }

    static final class BranchHeadNode extends ValueNode {
        private int length;
        private Node next;

        public BranchHeadNode(int i, Node node) {
            this.length = i;
            this.next = node;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public int hashCode() {
            return ((this.length + 248302782) * 37) + this.next.hashCode();
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!super.equals(obj)) {
                return false;
            }
            BranchHeadNode branchHeadNode = (BranchHeadNode) obj;
            return this.length == branchHeadNode.length && this.next == branchHeadNode.next;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.Node
        public int markRightEdgesFirst(int i) {
            if (this.offset != 0) {
                return i;
            }
            int markRightEdgesFirst = this.next.markRightEdgesFirst(i);
            this.offset = markRightEdgesFirst;
            return markRightEdgesFirst;
        }

        @Override // com.ibm.icu.util.StringTrieBuilder.ValueNode, com.ibm.icu.util.StringTrieBuilder.Node
        public void write(StringTrieBuilder stringTrieBuilder) {
            this.next.write(stringTrieBuilder);
            if (this.length <= stringTrieBuilder.getMinLinearMatch()) {
                this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, this.length - 1);
                return;
            }
            stringTrieBuilder.write(this.length - 1);
            this.offset = stringTrieBuilder.writeValueAndType(this.hasValue, this.value, 0);
        }
    }

    /* access modifiers changed from: private */
    /* access modifiers changed from: public */
    private ValueNode createSuffixNode(CharSequence charSequence, int i, int i2) {
        ValueNode registerFinalValue = registerFinalValue(i2);
        if (i >= charSequence.length()) {
            return registerFinalValue;
        }
        int length = this.strings.length();
        this.strings.append(charSequence, i, charSequence.length());
        return new LinearMatchNode(this.strings, length, charSequence.length() - i, registerFinalValue);
    }
}
