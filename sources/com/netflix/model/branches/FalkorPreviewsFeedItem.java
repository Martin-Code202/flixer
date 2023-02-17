package com.netflix.model.branches;

import com.netflix.falkor.BranchMap;
import com.netflix.model.leafs.PreviewsFeedItemSummary;
import o.AbstractC1264;
public class FalkorPreviewsFeedItem extends BranchMap<PreviewsFeedItemSummary> {

    /* renamed from: ˏ  reason: contains not printable characters */
    private PreviewsFeedItemSummary f4094;

    public FalkorPreviewsFeedItem(AbstractC1264<PreviewsFeedItemSummary> r1) {
        super(r1);
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object get(String str) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1590949186:
                if (str.equals("previewSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return this.f4094;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public Object getOrCreate(String str) {
        Object obj = get(str);
        if (obj != null) {
            return obj;
        }
        char c = 65535;
        switch (str.hashCode()) {
            case -1590949186:
                if (str.equals("previewSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                PreviewsFeedItemSummary previewsFeedItemSummary = new PreviewsFeedItemSummary();
                this.f4094 = previewsFeedItemSummary;
                return previewsFeedItemSummary;
            default:
                return null;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void set(String str, Object obj) {
        char c = 65535;
        switch (str.hashCode()) {
            case -1590949186:
                if (str.equals("previewSummary")) {
                    c = 0;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                this.f4094 = (PreviewsFeedItemSummary) obj;
                return;
            default:
                return;
        }
    }

    @Override // com.netflix.falkor.BranchMap, o.AbstractC0730
    public void remove(String str) {
        set(str, null);
    }
}
