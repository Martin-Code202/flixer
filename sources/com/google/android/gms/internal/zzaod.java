package com.google.android.gms.internal;

import com.netflix.mediaclient.service.webclient.model.leafs.SubtitleDownloadRetryPolicy;
public final class zzaod {
    private static zzaoe<Boolean> zzdqy = zzaoe.zza("analytics.service_enabled", false, false);
    public static zzaoe<Boolean> zzdqz = zzaoe.zza("analytics.service_client_enabled", true, true);
    public static zzaoe<String> zzdra = zzaoe.zzc("analytics.log_tag", "GAv4", "GAv4-SVC");
    private static zzaoe<Long> zzdrb = zzaoe.zza("analytics.max_tokens", 60L, 60L);
    private static zzaoe<Float> zzdrc = zzaoe.zza("analytics.tokens_per_sec", 0.5f, 0.5f);
    public static zzaoe<Integer> zzdrd = zzaoe.zza("analytics.max_stored_hits", 2000, 20000);
    private static zzaoe<Integer> zzdre = zzaoe.zza("analytics.max_stored_hits_per_app", 2000, 2000);
    public static zzaoe<Integer> zzdrf = zzaoe.zza("analytics.max_stored_properties_per_app", 100, 100);
    public static zzaoe<Long> zzdrg = zzaoe.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
    public static zzaoe<Long> zzdrh = zzaoe.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
    private static zzaoe<Long> zzdri = zzaoe.zza("analytics.min_local_dispatch_millis", 120000L, 120000L);
    private static zzaoe<Long> zzdrj = zzaoe.zza("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
    public static zzaoe<Long> zzdrk = zzaoe.zza("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
    public static zzaoe<Long> zzdrl = zzaoe.zza("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
    public static zzaoe<Integer> zzdrm = zzaoe.zza("analytics.max_hits_per_dispatch", 20, 20);
    public static zzaoe<Integer> zzdrn = zzaoe.zza("analytics.max_hits_per_batch", 20, 20);
    public static zzaoe<String> zzdro = zzaoe.zzc("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
    public static zzaoe<String> zzdrp = zzaoe.zzc("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
    public static zzaoe<String> zzdrq = zzaoe.zzc("analytics.simple_endpoint", "/collect", "/collect");
    public static zzaoe<String> zzdrr = zzaoe.zzc("analytics.batching_endpoint", "/batch", "/batch");
    public static zzaoe<Integer> zzdrs = zzaoe.zza("analytics.max_get_length", 2036, 2036);
    public static zzaoe<String> zzdrt = zzaoe.zzc("analytics.batching_strategy.k", zzanl.BATCH_BY_COUNT.name(), zzanl.BATCH_BY_COUNT.name());
    public static zzaoe<String> zzdru;
    private static zzaoe<Integer> zzdrv = zzaoe.zza("analytics.max_hits_per_request.k", 20, 20);
    public static zzaoe<Integer> zzdrw = zzaoe.zza("analytics.max_hit_length.k", 8192, 8192);
    public static zzaoe<Integer> zzdrx = zzaoe.zza("analytics.max_post_length.k", 8192, 8192);
    public static zzaoe<Integer> zzdry = zzaoe.zza("analytics.max_batch_post_length", 8192, 8192);
    public static zzaoe<String> zzdrz = zzaoe.zzc("analytics.fallback_responses.k", "404,502", "404,502");
    public static zzaoe<Integer> zzdsa = zzaoe.zza("analytics.batch_retry_interval.seconds.k", 3600, 3600);
    private static zzaoe<Long> zzdsb = zzaoe.zza("analytics.service_monitor_interval", 86400000L, 86400000L);
    public static zzaoe<Integer> zzdsc = zzaoe.zza("analytics.http_connection.connect_timeout_millis", (int) SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS, (int) SubtitleDownloadRetryPolicy.DEFAULT_MAX_INTERVAL_MS);
    public static zzaoe<Integer> zzdsd = zzaoe.zza("analytics.http_connection.read_timeout_millis", 61000, 61000);
    public static zzaoe<Long> zzdse = zzaoe.zza("analytics.campaigns.time_limit", 86400000L, 86400000L);
    private static zzaoe<String> zzdsf = zzaoe.zzc("analytics.first_party_experiment_id", "", "");
    private static zzaoe<Integer> zzdsg = zzaoe.zza("analytics.first_party_experiment_variant", 0, 0);
    public static zzaoe<Boolean> zzdsh = zzaoe.zza("analytics.test.disable_receiver", false, false);
    public static zzaoe<Long> zzdsi = zzaoe.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
    public static zzaoe<Long> zzdsj = zzaoe.zza("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
    private static zzaoe<Long> zzdsk = zzaoe.zza("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
    private static zzaoe<Long> zzdsl = zzaoe.zza("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
    public static zzaoe<Long> zzdsm = zzaoe.zza("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
    public static zzaoe<Long> zzdsn = zzaoe.zza("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
    public static zzaoe<Long> zzdso = zzaoe.zza("analytics.initialization_warning_threshold", 5000L, 5000L);

    static {
        String name = zzanr.GZIP.name();
        zzdru = zzaoe.zzc("analytics.compression_strategy.k", name, name);
    }
}
