package com.netflix.mediaclient;
public enum StatusCode {
    UNKNOWN(-1),
    INTERNAL_ERROR(-2),
    NETWORK_ERROR(-3),
    NRD_ERROR(-4),
    OBSOLETE_APP_VERSION(-5),
    SET_FAILED(-6),
    CONFIG_REFRESH_FAILED(-7),
    FORCED_TESTING_ERROR(-8),
    INIT_SERVICE_TIMEOUT(-9),
    NOT_IMPLEMENTED(-10),
    NO_CONNECTIVITY(-11),
    CONFIG_DOWNLOAD_FAILED(-12),
    FATAL_CONFIG_DOWNLOAD_FAILED(-14),
    VOIP_CONFIG_DOWNLOAD_FAILED(-15),
    FATAL_ESN_BASED_CONFIG_DOWNLOAD_FAILED(-16),
    INVALID_ARGUMENTS(-17),
    FATAL_CONFIG_BLACKLISTED(-18),
    ESN_MIGRATION_NO_CONNECTIVITY(-19),
    NRD_INVALID_SW_VERSION(-20),
    NRD_LOGIN_ONGOING(-40),
    NRD_REGISTRATION_EXISTS(-41),
    ERROR_FORMER_MEMBER_CONSUMPTION(-47),
    ERROR_FORMER_MEMBER_REDIRECT(-48),
    ERROR_NEVER_MEMBER_CONSUMPTION(-49),
    ERROR_NEVER_MEMBER_REDIRECT(-50),
    ERROR_DVD_MEMBER_REDIRECT(-51),
    ERROR_UNRECOGNIZED_CONSUMPTION(-52),
    ERROR_UNRECOGNIZED_REDIRECT(-53),
    ERROR_UNRECOGNIZED_EMAIL(-54),
    ERROR_INCORRECT_PASSWORD(-55),
    ERROR_ACCOUNT_PASSWORD_NOT_SET(-56),
    USER_SIGNIN_THROTTLED(-56),
    USER_SIGNIN_FAILURE_TRY_SIGNUP(-57),
    USER_SIGNIN_RETRY(-58),
    WRONG_PATH(-60),
    USER_NOT_AUTHORIZED(-61),
    SERVER_ERROR(-62),
    MISSING_ID_IN_CACHE(-63),
    SERVER_ERROR_MAP_CACHE_MISS(-64),
    MAP_ERROR(-65),
    BROWSE_AGENT_WRONG_STATE(-66),
    BROWSE_IQ_WRONG_STATE(-67),
    BROWSE_CW_WRONG_STATE(-68),
    DELETED_PROFILE(-69),
    INVALID_COUNRTY(-70),
    INSUFFICIENT_CONTENT(-71),
    SWITCH_PROFILE_UNKNOWN_ID(-72),
    FALKOR_RESPONSE_PARSE_ERROR(-80),
    DRM_FAILURE_CDM(-100),
    DRM_FAILURE_GOOGLE_CDM_PROVISIONG_DENIED(-101),
    DRM_FAILURE_CDM_KEY_SET_EMPTY(-102),
    DRM_FAILURE_CDM_RESOURCE_BUSY(-103),
    DRM_FAILURE_CDM_LICENSE_EMPTY(-104),
    DRM_FAILURE_FORCE_CRYPTO_FALLBACK(-105),
    DRM_FAILURE_CDM_NOT_PROVISIONED(-106),
    DRM_FAILURE_CDM_SERVER_DENIED(-107),
    DRM_FAILURE_CDM_EXCEPTION(-108),
    DRM_FAILURE_MEDIADRM_WIDEVINE_PLUGIN_BLOCKED(-109),
    DRM_FAILURE_MEDIADRM_WIDEVINE_PLUGIN_CHANGED(-110),
    DRM_FAILURE_MEDIADRM_SIGN(-111),
    DRM_FAILURE_MEDIADRM_VERIFY(-112),
    DRM_FAILURE_MEDIADRM_DECRYPT(-113),
    DRM_FAILURE_MEDIADRM_ENCRYPT(-114),
    DRM_FAILURE_MEDIADRM_GET_KEY_REQUEST(-115),
    DRM_FAILURE_MEDIADRM_PROVIDE_KEY_RESPONSE(-116),
    DRM_FAILURE_MEDIADRM_KEYS_RESTORE_FAILED(-117),
    DRM_FAILURE_MEDIADRM_RESET(-118),
    DRM_FAILURE_GOOGLE_DECLINED_PROVISIONING(-119),
    HTTP_SSL_ERROR(-120),
    HTTP_SSL_DATE_TIME_ERROR(-121),
    HTTP_SSL_NO_VALID_CERT(-122),
    HTTP_ERR_404(-123),
    HTTP_ERR_TIMEOUT(-124),
    HTTP_ERR_MALFORMED_URL(-125),
    HTTP_ERR_NOT_RESOLVED(-126),
    HTTP_ERROR_UNKNOWN(-127),
    DL_URL_DOWNLOAD_DISK_IO_ERROR(-130),
    DL_TITTLE_ALREADY_DOWNLOADED(-131),
    DL_REGISTRY_CHECKSUM_FAILED(-132),
    DL_ALL_CDN_URLS_FAILED(-133),
    DL_OFFLINE_STORAGE_NOT_AVAILABLE(-134),
    DL_CANT_CREATE_VIEWABLE_DIRECTORY(-135),
    DL_CANT_PERSIST_MANIFEST(-136),
    DL_MANIFEST_NO_TRACKS_TO_DOWNLOAD(-137),
    DL_CANT_DELETE_DOWNLOADABLES(-138),
    DL_CANT_DELETE_PLAYABLE_DIRECTORY(-139),
    DL_NOT_ENOUGH_FREE_SPACE(-140),
    DL_MANIFEST_NOT_FOUND_IN_CACHE(-141),
    DL_CANT_PERSIST_REGISTRY(-142),
    DL_TITTLE_ALREADY_REQUESTED_FOR_DOWNLOAD(-143),
    DL_OFFLINE_AGENT_NOT_READY(-144),
    DL_OFFLINE_PLAYABLE_NOT_FOUND(-145),
    DL_USER_NOT_LOGGED_IN(-147),
    DL_ENCODES_ARE_NOT_AVAILABLE(-148),
    DL_MANIFEST_DATA_MISSING(-149),
    DL_BUSY_TRY_DELETE_AGAIN(-150),
    DL_PLAY_WINDOW_RENEW_FAILED(-151),
    DL_LIMIT_CANT_DOWNLOAD_TILL_DATE(-152),
    DL_LIMIT_TOO_MANY_DOWNLOADED_DELETE_SOME(-153),
    DL_LIMIT_TOO_MANY_DEVICES_PLAN_OPTION(-154),
    DL_ENCODES_DELETE_ON_REVOCATION(-155),
    DL_TOTAL_LICENSE_PER_DEVICE_LIMIT(-156),
    DL_VIEWABLE_DIRECTORY_MISSING(-157),
    DL_BLACKLISTED_DEVICE(-158),
    DRM_FAILURE_CDM_NO_LICENSE_RELEASE_ACK(-160),
    NRD_LOGIN_ACTIONID_1(-200),
    NRD_LOGIN_ACTIONID_2(-201),
    NRD_LOGIN_ACTIONID_3(-202),
    NRD_LOGIN_ACTIONID_4(-203),
    NRD_LOGIN_ACTIONID_5(-204),
    NRD_LOGIN_ACTIONID_6(-205),
    NRD_LOGIN_ACTIONID_7(-206),
    NRD_LOGIN_ACTIONID_8(-207),
    NRD_LOGIN_ACTIONID_9(-208),
    NRD_LOGIN_ACTIONID_10(-209),
    NRD_LOGIN_ACTIONID_11(-210),
    NRD_LOGIN_ACTIONID_12(-211),
    RESPONSE_PARSE_ERROR(-300),
    BLADERUNNER_FAILURE(-320),
    OFFLINE_LICENSE_MAX_DEVICE_LIMIT(-321),
    OFFLINE_LICENSE_NOT_TESTER(-322),
    OFFLINE_LICENSE_ERROR(-323),
    OFFLINE_LICENSE_FETCH_NEW(-324),
    BLADERUNNER_RETRY(-325),
    API_REQUEST_UNSUCCESSFUL(-326),
    INT_ERR_ADVIS_VIDEO_ID_NULL(-360),
    INT_ERR_CMP(-361),
    INT_ERR_CMP_RESP_NULL(-362),
    INT_ERR_MDX_INIT(-363),
    INT_ERR_RESOURCE_URL_NULL(-364),
    INT_ERR_CB_NULL(-365),
    INT_ERR_REALM_DETAILS_NULL(-366),
    INT_ERR_MNGR_NOT_READY(-367),
    INT_ERR_SERVICE_DISCONNECTED(-368),
    INT_ERR_BAD_COOKIES(-369),
    INT_ERR_FALKOR_EXCEPTION(-370),
    NET_GENERAL_NETWORK_ERROR(-400),
    NET_UNKNOWN_HOST_EXCEPTION(-401),
    NET_CONNECTION_EXCEPTION(-402),
    NET_SOCKET_TIMEOUT_EXCEPTION(-403),
    NET_MALFORMED_URL_ERROR(-404),
    NET_NETWORK_IO_EXCEPTION(-405),
    NET_CRONET_HOSTNAME_NOT_RESOLVED(-420),
    NET_CRONET_INTERNET_DISCONNECTED(-421),
    NET_CRONET_NETWORK_CHANGED(-422),
    NET_CRONET_TIMED_OUT(-423),
    NET_CRONET_CONNECTION_CLOSED(-424),
    NET_CRONET_CONNECTION_TIMED_OUT(-425),
    NET_CRONET_CONNECTION_REFUSED(-426),
    NET_CRONET_CONNECTION_RESET(-427),
    NET_CRONET_ADDRESS_UNREACHABLE(-428),
    NET_CRONET_QUIC_PROTOCOL_FAILED(-429),
    NET_CRONET_ERROR_OTHER(-430),
    NET_LAST_NETWORK_ERROR(-499),
    MSL_FAILED_TO_CREATE_CLIENT(-1001),
    MSL_FAILED_TO_UPDATE_USER_ID(-1002),
    MSL_LEGACY_CRYPTO(-1003),
    MSL_BLACKLISTED_DEVICE_FAILBACK(-1004),
    MSL_BLACKLISTED_DEVICE_FATAL(-1005),
    MSL_LEGACY_CRYPTO_BUT_USED_WIDEVINE_BEFORE(-1006),
    MSL_GENERIC_NETWORK_ERROR(-1007),
    MSL_USERAUTH_ENTITY_MISMATCH(-1008),
    MSL_GENERIC_EXCEPTION(-1009),
    MSL_WV_DECRYPT_ERROR(-1010),
    MSL_WV_ENCRYPT_ERROR(-1011),
    MSL_WV_VERIFY_ERROR(-1012),
    MSL_WV_SIGN_ERROR(-1013),
    MSL_SWITCH_PROFILE_BIND_FAIL(-1014),
    MSL_SWITCH_PROFILE_NO_AUTH_DATA(-1015),
    MSL_SWITCH_PROFILE_FAILED(-1016),
    MSL_LAST_MSL_ERROR(-1100),
    MANIFEST_PARSE_ERROR(-2001),
    MANIFEST_PREFETCH_PROCESSING_ERROR(-2200),
    MANIFEST_CACHE_EXTRACT_ERROR(-2300),
    OK(0),
    NON_RECOMMENDED_APP_VERSION(1),
    NON_SUPPORTED_LOCALE(2),
    ALREADY_IN_QUEUE(10),
    NOT_IN_QUEUE(11),
    NOT_VALID(12),
    DL_WARNING_DL_N_TIMES_BEFORE_DATE(13),
    MANIFEST_PREFETCH_CANCELLED_BY_PLAYBACK(14);
    

    /* renamed from: ˋᶥ  reason: contains not printable characters */
    private static final int f701 = DRM_FAILURE_CDM.m271();

    /* renamed from: ˋﾞ  reason: contains not printable characters */
    private static final int f703 = DRM_FAILURE_GOOGLE_DECLINED_PROVISIONING.m271();

    /* renamed from: ˌˎ  reason: contains not printable characters */
    private static final int f706 = MANIFEST_CACHE_EXTRACT_ERROR.m271();

    /* renamed from: ˌˏ  reason: contains not printable characters */
    private static final int f707 = MANIFEST_PARSE_ERROR.m271();

    /* renamed from: ˌᐝ  reason: contains not printable characters */
    private static final int f709 = HTTP_ERROR_UNKNOWN.m271();

    /* renamed from: ˍˎ  reason: contains not printable characters */
    private static final int f711 = HTTP_SSL_ERROR.m271();

    /* renamed from: ˋꞌ  reason: contains not printable characters */
    private int f804;

    private StatusCode(int i) {
        this.f804 = i;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public int m271() {
        return this.f804;
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public boolean m268() {
        return this.f804 < 0;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public boolean m269() {
        return this.f804 >= 0;
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public boolean m270() {
        return this.f804 > 0;
    }

    @Override // java.lang.Enum, java.lang.Object
    public String toString() {
        return "StatusCode: [ code: " + this.f804 + ", name: " + name() + "]";
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    public static StatusCode m264(int i) {
        StatusCode[] values = values();
        for (StatusCode statusCode : values) {
            if (statusCode != null && statusCode.m271() == i) {
                return statusCode;
            }
        }
        return null;
    }

    /* renamed from: ॱ  reason: contains not printable characters */
    public boolean m272() {
        return m265(m271(), f703, f701);
    }

    /* renamed from: ʽ  reason: contains not printable characters */
    public boolean m267() {
        return m265(m271(), MSL_LAST_MSL_ERROR.m271(), MSL_FAILED_TO_CREATE_CLIENT.m271());
    }

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public boolean m273() {
        return m265(m271(), f709, f711);
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public boolean m266() {
        return m265(m271(), f706, f707);
    }

    /* renamed from: ˊ  reason: contains not printable characters */
    public static boolean m263(int i) {
        return m265(i, NET_LAST_NETWORK_ERROR.m271(), NET_GENERAL_NETWORK_ERROR.m271());
    }

    /* renamed from: ˎ  reason: contains not printable characters */
    private static boolean m265(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }
}
