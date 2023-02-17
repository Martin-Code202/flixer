package o;
public class sA extends AbstractC2164sv {
    public sA(C2167sy syVar) {
        super(syVar);
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean mo10502() {
        if (m10857().getServiceManager().m9809().mo1245()) {
            C1283.m16854("DialogManager", "User was already prompted for opt-in to social");
            return false;
        } else if (m10857().isDialogFragmentVisible()) {
            C1283.m16865("DialogManager", "Dialog fragment is already displayed. There should only be one visible at time. Do NOT display opt-in to social.");
            return false;
        } else {
            C1283.m16854("DialogManager", "User was NOT prompted for opt-in to social and no dialogs are visible.");
            return true;
        }
    }

    @Override // o.AbstractC2164sv
    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean mo10503() {
        return m10857().showDialog(C2382zp.m13718());
    }
}
