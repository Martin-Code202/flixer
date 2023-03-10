package android.arch.lifecycle;

import java.util.HashMap;
public class ViewModelStore {
    private final HashMap<String, ViewModel> mMap = new HashMap<>();

    /* access modifiers changed from: package-private */
    public final void put(String str, ViewModel viewModel) {
        ViewModel viewModel2 = this.mMap.get(str);
        if (viewModel2 != null) {
            viewModel2.onCleared();
        }
        this.mMap.put(str, viewModel);
    }

    /* access modifiers changed from: package-private */
    public final ViewModel get(String str) {
        return this.mMap.get(str);
    }

    public final void clear() {
        for (ViewModel viewModel : this.mMap.values()) {
            viewModel.onCleared();
        }
        this.mMap.clear();
    }
}
