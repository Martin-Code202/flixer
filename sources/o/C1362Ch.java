package o;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.netflix.mediaclient.service.logging.client.model.Error;
import com.netflix.mediaclient.service.logging.client.model.Event;
import com.netflix.mediaclient.service.logging.client.model.ExceptionClEvent;
import com.netflix.mediaclient.service.logging.client.model.UIError;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogActionData;
import com.netflix.mediaclient.service.pservice.logging.PreAppWidgetLogData;
import com.netflix.mediaclient.servicemgr.IClientLogging;
import com.netflix.mediaclient.servicemgr.PlayLocationType;
import com.netflix.mediaclient.servicemgr.UserActionLogging;
import org.json.JSONException;
import org.json.JSONObject;
/* renamed from: o.Ch  reason: case insensitive filesystem */
public final class C1362Ch extends AbstractC1358Cd {
    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4404(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4400(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_LOGIN_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4393(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4408(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, PlayLocationType playLocationType) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_START_PLAY_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (num != null) {
                intent.putExtra("rank", num.intValue());
            }
            if (playLocationType != null) {
                intent.putExtra("playLocation", playLocationType);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4389(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4401(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_TO_PLAYLIST_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (num != null) {
                intent.putExtra("title_rank", num.intValue());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4419(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4416(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            intent.putExtra("surveyType", str);
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4411(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4386(IClientLogging.CompletionReason completionReason, UIError uIError, String str, String str2) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SURVEY_QUESTION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            intent.putExtra("question", str);
            intent.putExtra("response", str2);
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public static void m4379(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4385(IClientLogging.CompletionReason completionReason, UIError uIError, String str) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_CHANGE_VALUE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (C1349Bv.m4107(str)) {
                intent.putExtra("new_value", str);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static void m4422(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4406(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_REMOVE_FROM_PLAYLIST_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public static void m4381(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4391(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_HIDE_FROM_HISTORY_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public static void m4380(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4384(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num, Integer num2, String str, Integer num3, Boolean bool) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_RATE_TITLE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (num != null) {
                intent.putExtra("rank", num.intValue());
            }
            if (num2 != null) {
                intent.putExtra("rating", num2.intValue());
            }
            if (str != null) {
                intent.putExtra("rating_type", str);
            }
            if (num3 != null) {
                intent.putExtra("score", num3.intValue());
            }
            if (bool != null) {
                intent.putExtra("is_new", bool.booleanValue());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4415(long j, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, String str) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            intent.putExtra("id", j);
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            if (str != null) {
                intent.putExtra("term", str);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4397(long j, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SEARCH_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("id", j);
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static void m4423(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (modalView != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4388(IClientLogging.ModalView modalView, IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!") && modalView != null) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_NAVIGATION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4420(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, String str, UserActionLogging.RememberProfile rememberProfile) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            intent.putExtra("profile_id", str);
            if (rememberProfile != null) {
                intent.putExtra("remember_profile", rememberProfile.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4418(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PROFILE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("view", modalView.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static void m4421(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4402(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, UserActionLogging.C0029 r7) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_ADD_PROFILE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("view", modalView.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (r7 != null) {
                intent.putExtra("profile_is_kids", r7.m1568());
                if (r7.m1566() != null) {
                    intent.putExtra("profile_id", r7.m1566());
                }
                if (r7.m1570() != null) {
                    intent.putExtra("profile_name", r7.m1570());
                }
                if (r7.m1569() != null) {
                    intent.putExtra("profile_age", r7.m1569().intValue());
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ͺ  reason: contains not printable characters */
    public static void m4414(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4387(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError, UserActionLogging.C0029 r7) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_EDIT_PROFILE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("view", modalView.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (r7 != null) {
                intent.putExtra("profile_is_kids", r7.m1568());
                if (r7.m1566() != null) {
                    intent.putExtra("profile_id", r7.m1566());
                }
                if (r7.m1570() != null) {
                    intent.putExtra("profile_name", r7.m1570());
                }
                if (r7.m1569() != null) {
                    intent.putExtra("profile_age", r7.m1569().intValue());
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4412(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, String str) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            intent.putExtra("profile_id", str);
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4409(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_DELETE_PROFILE_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("view", modalView.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4405(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        if (commandName != null) {
            intent.putExtra("cmd", commandName.name());
        }
        intent.putExtra("url", str);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4382(IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4395(String str, UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        if (commandName != null) {
            intent.putExtra("cmd", commandName.name());
        }
        intent.putExtra("url", str);
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4398(IClientLogging.CompletionReason completionReason, Error error) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SHARE_SHEET_OPEN_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static void m4413(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_START");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        if (commandName != null) {
            intent.putExtra("cmd", commandName.name());
        }
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4399(IClientLogging.CompletionReason completionReason, Error error, String str, String str2, Long l, String str3, String str4) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_NEW_LOLOMO_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (C1349Bv.m4113(str)) {
                intent.putExtra("renoCause", str);
            }
            if (C1349Bv.m4113(str2)) {
                intent.putExtra("renoMessageGuid", str2);
            }
            if (l != null) {
                intent.putExtra("renoCreationTimestamp", l.longValue());
            }
            if (C1349Bv.m4113(str3)) {
                intent.putExtra("mercuryMessageGuid", str3);
            }
            if (C1349Bv.m4113(str4)) {
                intent.putExtra("mercuryEventGuid", str4);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static void m4403(UserActionLogging.CommandName commandName, PreAppWidgetLogData preAppWidgetLogData, PreAppWidgetLogActionData preAppWidgetLogActionData) {
        if (!m4349(preAppWidgetLogData, "widgetLogData can not be null!") && !m4349(preAppWidgetLogActionData, "widgetLogActionData can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("cmd", commandName.name());
            intent.putExtra(PreAppWidgetLogData.EXTRA_WIDGET_LOG_DATA, preAppWidgetLogData.toJsonString());
            intent.putExtra(PreAppWidgetLogActionData.EXTRA_WIDGET_ACTION_DATA, preAppWidgetLogActionData.toJsonString());
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4383(IClientLogging.CompletionReason completionReason, UIError uIError) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.PREAPP_WIDGET_ACTION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4396(boolean z, int i, UserActionLogging.PostPlayExperience postPlayExperience) {
        C1283.m16854("nf_log", "Report postplay starts!");
        if (!m4349(postPlayExperience, "postPlayExperience can not be null")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("isAutoPlayCountdownEnabled", z);
            intent.putExtra("lengthOfAutoPlayCountdown", i);
            if (postPlayExperience != null) {
                intent.putExtra("postPlayExperience", postPlayExperience.toString());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4392(IClientLogging.CompletionReason completionReason, IClientLogging.ModalView modalView, Error error, boolean z, boolean z2, Integer num, Integer num2, int i) {
        C1283.m16854("nf_log", "Report postplay ends!");
        if (!m4349(completionReason, "Reason can not be null!") && !m4349(modalView, "Destination can not be null")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_POSTPLAY_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("view", modalView.name());
            if (error != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, error.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            intent.putExtra("wasAutoPlayCountdownInterrupted", z);
            intent.putExtra("didUserContinueWatching", z2);
            if (num != null) {
                intent.putExtra("chosenVideoId", num);
            }
            if (num2 != null) {
                intent.putExtra("chosenIndex", num2);
            }
            intent.putExtra("trackId", i);
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public static void m4394(String str, IClientLogging.ModalView modalView, JSONObject jSONObject) {
        Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_CUSTOM_ACTION");
        intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
        if (modalView != null) {
            intent.putExtra("view", modalView.name());
        }
        intent.putExtra("cmd", str);
        if (jSONObject != null) {
            intent.putExtra(Event.CUSTOM, jSONObject.toString());
        }
        LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4410(IClientLogging.ModalView modalView) {
        if (!m4349(modalView, "Source can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            if (modalView != null) {
                intent.putExtra("view", modalView.name());
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public static void m4417(IClientLogging.CompletionReason completionReason, UIError uIError, String str, boolean z, boolean z2, String str2) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_REGISTER_FOR_PUSH_NOTIFICATION_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            intent.putExtra("userPushOptIn", z);
            intent.putExtra("infoPushOptIn", z2);
            if (C1349Bv.m4107(str)) {
                intent.putExtra("deviceToken", str);
            }
            if (C1349Bv.m4107(str2)) {
                intent.putExtra("oldDeviceToken", str2);
            }
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static void m4390(UserActionLogging.CommandName commandName, IClientLogging.ModalView modalView, Integer num) {
        if (!m4349(modalView, "View can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_START");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("view", modalView.name());
            if (commandName != null) {
                intent.putExtra("cmd", commandName.name());
            }
            if (num != null) {
                intent.putExtra("plan_id", num);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public static void m4407(IClientLogging.CompletionReason completionReason, UIError uIError, Integer num) {
        if (!m4349(completionReason, "Reason can not be null!")) {
            Intent intent = new Intent("com.netflix.mediaclient.intent.action.LOG_UIA_SELECT_PLAN_ENDED");
            intent.addCategory("com.netflix.mediaclient.intent.category.LOGGING");
            intent.putExtra("reason", completionReason.name());
            if (uIError != null) {
                try {
                    intent.putExtra(ExceptionClEvent.CATEGORY_VALUE, uIError.toJSONObject().toString());
                } catch (JSONException e) {
                    C1283.m16847("nf_log", "Failed to get JSON string from UIError", e);
                }
            }
            if (num != null) {
                intent.putExtra("plan_id", num);
            }
            LocalBroadcastManager.getInstance(AbstractApplicationC1258.m16692()).sendBroadcast(intent);
        }
    }
}
