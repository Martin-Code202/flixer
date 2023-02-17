package o;

import com.netflix.msl.MslConstants;
import com.netflix.msl.MslInternalException;
import java.util.HashSet;
import java.util.Set;
public class CK {

    /* renamed from: ʳ  reason: contains not printable characters */
    public static final CK f4733 = new CK(5008, MslConstants.ResponseCode.FAIL, "Unsupported user authentication data.");

    /* renamed from: ʴ  reason: contains not printable characters */
    public static final CK f4734 = new CK(5021, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data user ID token is not decrypted or verified.");

    /* renamed from: ʹ  reason: contains not printable characters */
    public static final CK f4735 = new CK(63, MslConstants.ResponseCode.FAIL, "Error generating key.");

    /* renamed from: ʹॱ  reason: contains not printable characters */
    public static final CK f4736 = new CK(5013, MslConstants.ResponseCode.FAIL, "Unable to identify user authentication mechanism.");

    /* renamed from: ʻ  reason: contains not printable characters */
    public static final CK f4737 = new CK(5, MslConstants.ResponseCode.FAIL, "Plaintext is not a multiple of the block size.");

    /* renamed from: ʻʻ  reason: contains not printable characters */
    public static final CK f4738 = new CK(5014, MslConstants.ResponseCode.FAIL, "Unsupported user authentication mechanism.");

    /* renamed from: ʻʼ  reason: contains not printable characters */
    public static final CK f4739 = new CK(5016, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication required master token is missing.");

    /* renamed from: ʻʽ  reason: contains not printable characters */
    public static final CK f4740 = new CK(5024, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data master token is invalid.");

    /* renamed from: ʻˊ  reason: contains not printable characters */
    public static final CK f4741 = new CK(65, MslConstants.ResponseCode.FAIL, "Invalid ciphertext.");

    /* renamed from: ʻˋ  reason: contains not printable characters */
    public static final CK f4742 = new CK(1001, MslConstants.ResponseCode.ENTITY_REAUTH, "Unable to construct symmetric keys from master token.");

    /* renamed from: ʻॱ  reason: contains not printable characters */
    public static final CK f4743 = new CK(19, MslConstants.ResponseCode.FAIL, "Error decrypting ciphertext.");

    /* renamed from: ʻᐝ  reason: contains not printable characters */
    public static final CK f4744 = new CK(1002, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token expiration timestamp is before the renewal window opens.");

    /* renamed from: ʼ  reason: contains not printable characters */
    public static final CK f4745 = new CK(7, MslConstants.ResponseCode.FAIL, "Ciphertext is not a multiple of the block size.");

    /* renamed from: ʼʻ  reason: contains not printable characters */
    public static final CK f4746 = new CK(5030, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication required user ID token is missing.");

    /* renamed from: ʼʼ  reason: contains not printable characters */
    public static final CK f4747 = new CK(5032, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data does not match entity identity.");

    /* renamed from: ʼʽ  reason: contains not printable characters */
    public static final CK f4748 = new CK(5037, MslConstants.ResponseCode.USERDATA_REAUTH, "User is rejected by the application.");

    /* renamed from: ʼˊ  reason: contains not printable characters */
    public static final CK f4749 = new CK(1000, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token is not trusted.");

    /* renamed from: ʼˋ  reason: contains not printable characters */
    public static final CK f4750 = new CK(64, MslConstants.ResponseCode.FAIL, "Invalid initialization vector.");

    /* renamed from: ʼॱ  reason: contains not printable characters */
    public static final CK f4751 = new CK(20, MslConstants.ResponseCode.FAIL, "Insufficient ciphertext for decryption.");

    /* renamed from: ʼᐝ  reason: contains not printable characters */
    public static final CK f4752 = new CK(1006, MslConstants.ResponseCode.ENTITY_REAUTH, "Invalid master token data.");

    /* renamed from: ʽ  reason: contains not printable characters */
    public static final CK f4753 = new CK(8, MslConstants.ResponseCode.FAIL, "Ciphertext contains incorrect padding.");

    /* renamed from: ʽʻ  reason: contains not printable characters */
    public static final CK f4754 = new CK(5025, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data master token is not decrypted or verified.");

    /* renamed from: ʽʼ  reason: contains not printable characters */
    public static final CK f4755 = new CK(5033, MslConstants.ResponseCode.FAIL, "Entity used incorrect user authentication data type.");

    /* renamed from: ʽʽ  reason: contains not printable characters */
    public static final CK f4756 = new CK(6000, MslConstants.ResponseCode.FAIL, "Unsupported compression algorithm.");

    /* renamed from: ʽˊ  reason: contains not printable characters */
    public static final CK f4757 = new CK(1007, MslConstants.ResponseCode.ENTITY_REAUTH, "Invalid master token signature.");

    /* renamed from: ʽˋ  reason: contains not printable characters */
    public static final CK f4758 = new CK(1003, MslConstants.ResponseCode.ENTITY_REAUTH, "No master token session data found.");

    /* renamed from: ʽॱ  reason: contains not printable characters */
    public static final CK f4759 = new CK(25, MslConstants.ResponseCode.FAIL, "Invalid encryption key.");

    /* renamed from: ʽᐝ  reason: contains not printable characters */
    public static final CK f4760 = new CK(1005, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token serial number is out of range.");

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final CK f4761 = new CK(26, MslConstants.ResponseCode.FAIL, "Invalid HMAC key.");

    /* renamed from: ʾˊ  reason: contains not printable characters */
    public static final CK f4762 = new CK(6001, MslConstants.ResponseCode.FAIL, "Error compressing data.");

    /* renamed from: ʾˋ  reason: contains not printable characters */
    public static final CK f4763 = new CK(5042, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data signature verification failed.");

    /* renamed from: ʾॱ  reason: contains not printable characters */
    public static final CK f4764 = new CK(1004, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token sequence number is out of range.");

    /* renamed from: ʾᐝ  reason: contains not printable characters */
    public static final CK f4765 = new CK(5041, MslConstants.ResponseCode.USERDATA_REAUTH, "Entity and user combination used incorrect user authentication data type.");

    /* renamed from: ʿ  reason: contains not printable characters */
    public static final CK f4766 = new CK(24, MslConstants.ResponseCode.FAIL, "Invalid symmetric key.");

    /* renamed from: ʿˊ  reason: contains not printable characters */
    public static final CK f4767 = new CK(5040, MslConstants.ResponseCode.USERDATA_REAUTH, "The entity is not associated with the user.");

    /* renamed from: ʿˋ  reason: contains not printable characters */
    public static final CK f4768 = new CK(6002, MslConstants.ResponseCode.FAIL, "Error uncompressing data.");

    /* renamed from: ʿॱ  reason: contains not printable characters */
    public static final CK f4769 = new CK(1012, MslConstants.ResponseCode.ENTITY_REAUTH, "Error parsing master token session data.");

    /* renamed from: ʿᐝ  reason: contains not printable characters */
    public static final CK f4770 = new CK(6004, MslConstants.ResponseCode.FAIL, "Payload chunk message ID does not match header message ID .");

    /* renamed from: ˆ  reason: contains not printable characters */
    public static final CK f4771 = new CK(6003, MslConstants.ResponseCode.FAIL, "Message header entity authentication data or master token not found.");

    /* renamed from: ˇ  reason: contains not printable characters */
    public static final CK f4772 = new CK(6005, MslConstants.ResponseCode.FAIL, "Payload chunk sequence number does not match expected sequence number.");

    /* renamed from: ˈ  reason: contains not printable characters */
    public static final CK f4773 = new CK(21, MslConstants.ResponseCode.FAIL, "Error when creating session keys.");

    /* renamed from: ˈˊ  reason: contains not printable characters */
    public static final CK f4774 = new CK(6006, MslConstants.ResponseCode.FAIL, "Payload chunk payload signature verification failed.");

    /* renamed from: ˈˋ  reason: contains not printable characters */
    public static final CK f4775 = new CK(6009, MslConstants.ResponseCode.FAIL, "Message header/error data signature verification failed.");

    /* renamed from: ˈॱ  reason: contains not printable characters */
    public static final CK f4776 = new CK(1009, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token sequence number does not have the expected value.");

    /* renamed from: ˈᐝ  reason: contains not printable characters */
    public static final CK f4777 = new CK(6010, MslConstants.ResponseCode.FAIL, "No header data found.");

    /* renamed from: ˉ  reason: contains not printable characters */
    public static final CK f4778 = new CK(29, MslConstants.ResponseCode.FAIL, "Unidentified JSON web key type.");

    /* renamed from: ˉˊ  reason: contains not printable characters */
    public static final CK f4779 = new CK(6007, MslConstants.ResponseCode.FAIL, "No message data found.");

    /* renamed from: ˉˋ  reason: contains not printable characters */
    public static final CK f4780 = new CK(6008, MslConstants.ResponseCode.FAIL, "Malformed message data.");

    /* renamed from: ˉॱ  reason: contains not printable characters */
    public static final CK f4781 = new CK(1011, MslConstants.ResponseCode.ENTITY_REAUTH, "Error parsing master token data.");

    /* renamed from: ˉᐝ  reason: contains not printable characters */
    public static final CK f4782 = new CK(6011, MslConstants.ResponseCode.FAIL, "No payload data found in non-EOM payload chunk.");

    /* renamed from: ˊ  reason: contains not printable characters */
    public static final CK f4783 = new CK(1, MslConstants.ResponseCode.FAIL, "Error encoding MSL encodable.");

    /* renamed from: ˊʻ  reason: contains not printable characters */
    public static final CK f4784 = new CK(1010, MslConstants.ResponseCode.ENTITY_REAUTH, "No master token data found.");

    /* renamed from: ˊʼ  reason: contains not printable characters */
    public static final CK f4785 = new CK(1008, MslConstants.ResponseCode.ENTITY_REAUTH, "Invalid master token session data.");

    /* renamed from: ˊʽ  reason: contains not printable characters */
    public static final CK f4786 = new CK(1015, MslConstants.ResponseCode.FAIL, "Master token issuer data encoding error.");

    /* renamed from: ˊʾ  reason: contains not printable characters */
    public static final CK f4787 = new CK(6016, MslConstants.ResponseCode.FAIL, "Error header internal code is negative.");

    /* renamed from: ˊʿ  reason: contains not printable characters */
    public static final CK f4788 = new CK(6014, MslConstants.ResponseCode.EXPIRED, "Message expired and not renewable or missing key request data. Rejected.");

    /* renamed from: ˊˈ  reason: contains not printable characters */
    public static final CK f4789 = new CK(6013, MslConstants.ResponseCode.FAIL, "Unidentified compression algorithm.");

    /* renamed from: ˊˉ  reason: contains not printable characters */
    public static final CK f4790 = new CK(6012, MslConstants.ResponseCode.FAIL, "Corrupt payload data found in non-EOM payload chunk.");

    /* renamed from: ˊˊ  reason: contains not printable characters */
    public static final CK f4791 = new CK(31, MslConstants.ResponseCode.FAIL, "Unidentified JSON web key algorithm.");

    /* renamed from: ˊˋ  reason: contains not printable characters */
    public static final CK f4792 = new CK(27, MslConstants.ResponseCode.FAIL, "Wrap not supported.");

    /* renamed from: ˊˑ  reason: contains not printable characters */
    public static final CK f4793 = new CK(6015, MslConstants.ResponseCode.FAIL, "Message ID is is out of range.");

    /* renamed from: ˊॱ  reason: contains not printable characters */
    public static final CK f4794 = new CK(11, MslConstants.ResponseCode.FAIL, "Encryption envelope key ID does not match crypto context key ID.");

    /* renamed from: ˊᐝ  reason: contains not printable characters */
    public static final CK f4795 = new CK(28, MslConstants.ResponseCode.FAIL, "Unwrap not supported.");

    /* renamed from: ˊᐧ  reason: contains not printable characters */
    public static final CK f4796 = new CK(6021, MslConstants.ResponseCode.REPLAYED, "Non-replayable message replayed.");

    /* renamed from: ˊᐨ  reason: contains not printable characters */
    public static final CK f4797 = new CK(6020, MslConstants.ResponseCode.FAIL, "Payload chunk message ID is out of range.");

    /* renamed from: ˊᶥ  reason: contains not printable characters */
    public static final CK f4798 = new CK(6018, MslConstants.ResponseCode.KEYX_REQUIRED, "Message response requires encryption.");

    /* renamed from: ˊꜞ  reason: contains not printable characters */
    public static final CK f4799 = new CK(6017, MslConstants.ResponseCode.FAIL, "Unexpected response message ID. Possible replay.");

    /* renamed from: ˊꜟ  reason: contains not printable characters */
    public static final CK f4800 = new CK(6019, MslConstants.ResponseCode.FAIL, "Payload chunk sequence number is out of range.");

    /* renamed from: ˊꞌ  reason: contains not printable characters */
    public static final CK f4801 = new CK(6024, MslConstants.ResponseCode.FAIL, "Invalid header data.");

    /* renamed from: ˊﾞ  reason: contains not printable characters */
    public static final CK f4802 = new CK(6023, MslConstants.ResponseCode.FAIL, "Invalid Header signature.");

    /* renamed from: ˊﾟ  reason: contains not printable characters */
    public static final CK f4803 = new CK(6025, MslConstants.ResponseCode.FAIL, "Invalid payload.");

    /* renamed from: ˋ  reason: contains not printable characters */
    public static final CK f4804 = new CK(0, MslConstants.ResponseCode.FAIL, "Error parsing MSL encodable.");

    /* renamed from: ˋʻ  reason: contains not printable characters */
    public static final CK f4805 = new CK(1013, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token entity identity is revoked.");

    /* renamed from: ˋʼ  reason: contains not printable characters */
    public static final CK f4806 = new CK(1014, MslConstants.ResponseCode.ENTITY_REAUTH, "Master token is rejected by the application.");

    /* renamed from: ˋʽ  reason: contains not printable characters */
    public static final CK f4807 = new CK(2000, MslConstants.ResponseCode.USER_REAUTH, "User ID token master token serial number does not match master token serial number.");

    /* renamed from: ˋʾ  reason: contains not printable characters */
    public static final CK f4808 = new CK(6026, MslConstants.ResponseCode.FAIL, "Invalid payload signature.");

    /* renamed from: ˋʿ  reason: contains not printable characters */
    public static final CK f4809 = new CK(6022, MslConstants.ResponseCode.FAIL, "Non-replayable message sent without a master token.");

    /* renamed from: ˋˈ  reason: contains not printable characters */
    public static final CK f4810 = new CK(6029, MslConstants.ResponseCode.FAIL, "User-associated message requires user authentication data.");

    /* renamed from: ˋˉ  reason: contains not printable characters */
    public static final CK f4811 = new CK(6031, MslConstants.ResponseCode.FAIL, "Non-replayable message requires a master token.");

    /* renamed from: ˋˊ  reason: contains not printable characters */
    public static final CK f4812 = new CK(30, MslConstants.ResponseCode.FAIL, "Unidentified JSON web key usage.");

    /* renamed from: ˋˋ  reason: contains not printable characters */
    public static final CK f4813 = new CK(34, MslConstants.ResponseCode.FAIL, "Invalid JSON web key.");

    /* renamed from: ˋˑ  reason: contains not printable characters */
    public static final CK f4814 = new CK(6030, MslConstants.ResponseCode.FAIL, "Message sender is not the master token entity.");

    /* renamed from: ˋॱ  reason: contains not printable characters */
    public static final CK f4815 = new CK(14, MslConstants.ResponseCode.FAIL, "Sign not supported.");

    /* renamed from: ˋᐝ  reason: contains not printable characters */
    public static final CK f4816 = new CK(36, MslConstants.ResponseCode.FAIL, "Unsupported JSON web key algorithm.");

    /* renamed from: ˋᐧ  reason: contains not printable characters */
    public static final CK f4817 = new CK(6027, MslConstants.ResponseCode.KEYX_REQUIRED, "Message response requires a master token.");

    /* renamed from: ˋᐨ  reason: contains not printable characters */
    public static final CK f4818 = new CK(6028, MslConstants.ResponseCode.USER_REAUTH, "Message response requires a user ID token.");

    /* renamed from: ˋᶥ  reason: contains not printable characters */
    public static final CK f4819 = new CK(6036, MslConstants.ResponseCode.FAIL, "Handshake message is not renewable or does not contain key request data.");

    /* renamed from: ˋꜞ  reason: contains not printable characters */
    public static final CK f4820 = new CK(6033, MslConstants.ResponseCode.FAIL, "Service token master token or user ID token serial number does not match the message token serial numbers.");

    /* renamed from: ˋꞌ  reason: contains not printable characters */
    public static final CK f4821 = new CK(6035, MslConstants.ResponseCode.KEYX_REQUIRED, "Message response requires integrity protection.");

    /* renamed from: ˋﾞ  reason: contains not printable characters */
    public static final CK f4822 = new CK(6034, MslConstants.ResponseCode.FAIL, "Peer service token master token or user ID token serial number does not match the message peer token serial numbers.");

    /* renamed from: ˋﾟ  reason: contains not printable characters */
    public static final CK f4823 = new CK(6032, MslConstants.ResponseCode.FAIL, "Non-replayable message non-replayable ID is out of range.");

    /* renamed from: ˌ  reason: contains not printable characters */
    public static final CK f4824 = new CK(32, MslConstants.ResponseCode.FAIL, "Error wrapping plaintext.");

    /* renamed from: ˌˎ  reason: contains not printable characters */
    public static final CK f4825 = new CK(6039, MslConstants.ResponseCode.ENTITY_REAUTH, "Message header master token-based signature verification failed.");

    /* renamed from: ˌˏ  reason: contains not printable characters */
    public static final CK f4826 = new CK(6037, MslConstants.ResponseCode.FAIL, "Message recipient does not match local identity.");

    /* renamed from: ˌॱ  reason: contains not printable characters */
    public static final CK f4827 = new CK(2001, MslConstants.ResponseCode.USER_REAUTH, "User ID token is not decrypted or verified.");

    /* renamed from: ˌᐝ  reason: contains not printable characters */
    public static final CK f4828 = new CK(6038, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Message header entity-based signature verification failed.");

    /* renamed from: ˍ  reason: contains not printable characters */
    public static final CK f4829 = new CK(33, MslConstants.ResponseCode.FAIL, "Error unwrapping ciphertext.");

    /* renamed from: ˍˎ  reason: contains not printable characters */
    public static final CK f4830 = new CK(6041, MslConstants.ResponseCode.FAIL, "Message sender is equal to the local entity.");

    /* renamed from: ˍˏ  reason: contains not printable characters */
    public static final CK f4831 = new CK(6040, MslConstants.ResponseCode.ENTITY_REAUTH, "Non-replayable message replayed with a sequence number that is too far out of sync to recover.");

    /* renamed from: ˎ  reason: contains not printable characters */
    public static final CK f4832 = new CK(4, MslConstants.ResponseCode.FAIL, "Invalid private key provided.");

    /* renamed from: ˎˌ  reason: contains not printable characters */
    public static final CK f4833 = new CK(7000, MslConstants.ResponseCode.FAIL, "Unable to identify key exchange scheme.");

    /* renamed from: ˎˍ  reason: contains not printable characters */
    public static final CK f4834 = new CK(7001, MslConstants.ResponseCode.FAIL, "No factory registered for key exchange scheme.");

    /* renamed from: ˎˎ  reason: contains not printable characters */
    public static final CK f4835 = new CK(35, MslConstants.ResponseCode.FAIL, "Invalid JSON web key keydata.");

    /* renamed from: ˎˏ  reason: contains not printable characters */
    public static final CK f4836 = new CK(38, MslConstants.ResponseCode.FAIL, "Invalid wrap ciphertext.");

    /* renamed from: ˎͺ  reason: contains not printable characters */
    public static final CK f4837 = new CK(2003, MslConstants.ResponseCode.USER_REAUTH, "User ID token expiration timestamp is before the renewal window opens.");

    /* renamed from: ˎـ  reason: contains not printable characters */
    public static final CK f4838 = new CK(7002, MslConstants.ResponseCode.FAIL, "No key request found matching header key response data.");

    /* renamed from: ˎꓸ  reason: contains not printable characters */
    public static final CK f4839 = new CK(7003, MslConstants.ResponseCode.FAIL, "Unable to identify key exchange key ID.");

    /* renamed from: ˎꜟ  reason: contains not printable characters */
    public static final CK f4840 = new CK(7004, MslConstants.ResponseCode.FAIL, "Unsupported key exchange key ID.");

    /* renamed from: ˎﹳ  reason: contains not printable characters */
    public static final CK f4841 = new CK(7005, MslConstants.ResponseCode.FAIL, "Unable to identify key exchange mechanism.");

    /* renamed from: ˏ  reason: contains not printable characters */
    public static final CK f4842 = new CK(3, MslConstants.ResponseCode.FAIL, "Invalid public key provided.");

    /* renamed from: ˏˌ  reason: contains not printable characters */
    public static final CK f4843 = new CK(7006, MslConstants.ResponseCode.FAIL, "Unsupported key exchange mechanism.");

    /* renamed from: ˏˍ  reason: contains not printable characters */
    public static final CK f4844 = new CK(7007, MslConstants.ResponseCode.FAIL, "Key exchange response does not match request.");

    /* renamed from: ˏˎ  reason: contains not printable characters */
    public static final CK f4845 = new CK(37, MslConstants.ResponseCode.FAIL, "Error when creating wrapping key.");

    /* renamed from: ˏˏ  reason: contains not printable characters */
    public static final CK f4846 = new CK(41, MslConstants.ResponseCode.FAIL, "Error parsing JSON web encryption header.");

    /* renamed from: ˏͺ  reason: contains not printable characters */
    public static final CK f4847 = new CK(2006, MslConstants.ResponseCode.USER_REAUTH, "User ID token master token serial number is out of range.");

    /* renamed from: ˏـ  reason: contains not printable characters */
    public static final CK f4848 = new CK(7008, MslConstants.ResponseCode.FAIL, "Key exchange private key missing.");

    /* renamed from: ˏॱ  reason: contains not printable characters */
    public static final CK f4849 = new CK(13, MslConstants.ResponseCode.FAIL, "Error encoding ciphertext envelope.");

    /* renamed from: ˏᐧ  reason: contains not printable characters */
    public static final CK f4850 = new CK(7009, MslConstants.ResponseCode.FAIL, "Key exchange parameters ID unknown or invalid.");

    /* renamed from: ˏꓸ  reason: contains not printable characters */
    public static final CK f4851 = new CK(7013, MslConstants.ResponseCode.FAIL, "Key exchange wrapping key missing.");

    /* renamed from: ˏꜟ  reason: contains not printable characters */
    public static final CK f4852 = new CK(7011, MslConstants.ResponseCode.FAIL, "Key exchange public key is invalid.");

    /* renamed from: ˏﹳ  reason: contains not printable characters */
    public static final CK f4853 = new CK(7014, MslConstants.ResponseCode.FAIL, "Key exchange wrapping key ID missing.");

    /* renamed from: ˑ  reason: contains not printable characters */
    public static final CK f4854 = new CK(40, MslConstants.ResponseCode.FAIL, "Error encoding JSON web encryption header.");

    /* renamed from: ˑˊ  reason: contains not printable characters */
    public static final CK f4855 = new CK(7010, MslConstants.ResponseCode.FAIL, "Master token required for key exchange is missing.");

    /* renamed from: ˑˋ  reason: contains not printable characters */
    public static final CK f4856 = new CK(7012, MslConstants.ResponseCode.FAIL, "Key exchange public key missing.");

    /* renamed from: ˑॱ  reason: contains not printable characters */
    public static final CK f4857 = new CK(2002, MslConstants.ResponseCode.USER_REAUTH, "User ID token requires a master token.");

    /* renamed from: ˑᐝ  reason: contains not printable characters */
    public static final CK f4858 = new CK(7017, MslConstants.ResponseCode.FAIL, "Entity used incorrect key exchange mecahnism.");

    /* renamed from: ˡ  reason: contains not printable characters */
    public static final CK f4859 = new CK(7015, MslConstants.ResponseCode.FAIL, "Key exchange wrapping key is invalid.");

    /* renamed from: ˬ  reason: contains not printable characters */
    public static final CK f4860 = new CK(7018, MslConstants.ResponseCode.FAIL, "Key exchange derivation key missing.");

    /* renamed from: ˮ  reason: contains not printable characters */
    public static final CK f4861 = new CK(7016, MslConstants.ResponseCode.FAIL, "Entity used incorrect key exchange data type.");

    /* renamed from: ͺ  reason: contains not printable characters */
    public static final CK f4862 = new CK(12, MslConstants.ResponseCode.FAIL, "Error parsing ciphertext envelope.");

    /* renamed from: ͺˎ  reason: contains not printable characters */
    public static final CK f4863 = new CK(2005, MslConstants.ResponseCode.USER_REAUTH, "User ID token is bound to an unknown master token.");

    /* renamed from: ͺˏ  reason: contains not printable characters */
    public static final CK f4864 = new CK(2004, MslConstants.ResponseCode.USER_REAUTH, "No user ID token user data found.");

    /* renamed from: ͺͺ  reason: contains not printable characters */
    public static final CK f4865 = new CK(7019, MslConstants.ResponseCode.FAIL, "Key exchange encryption key is invalid.");

    /* renamed from: ͺॱ  reason: contains not printable characters */
    public static final CK f4866 = new CK(39, MslConstants.ResponseCode.FAIL, "Unsupported JSON web encryption algorithm.");

    /* renamed from: ՙ  reason: contains not printable characters */
    public static final CK f4867 = new CK(2011, MslConstants.ResponseCode.USER_REAUTH, "Invalid user ID token user identity.");

    /* renamed from: ՙॱ  reason: contains not printable characters */
    public static final CK f4868 = new CK(9000, MslConstants.ResponseCode.TRANSIENT_FAILURE, "Internal exception.");

    /* renamed from: י  reason: contains not printable characters */
    public static final CK f4869 = new CK(2008, MslConstants.ResponseCode.USER_REAUTH, "Invalid user ID token data.");

    /* renamed from: יॱ  reason: contains not printable characters */
    public static final CK f4870 = new CK(7020, MslConstants.ResponseCode.FAIL, "Key exchange HMAC key is invalid.");

    /* renamed from: ـ  reason: contains not printable characters */
    public static final CK f4871 = new CK(43, MslConstants.ResponseCode.FAIL, "JSON web encryption header algorithms mismatch.");

    /* renamed from: ـˎ  reason: contains not printable characters */
    public static final CK f4872 = new CK(7022, MslConstants.ResponseCode.FAIL, "Unsupported key exchange scheme.");

    /* renamed from: ـˏ  reason: contains not printable characters */
    public static final CK f4873 = new CK(7021, MslConstants.ResponseCode.FAIL, "Key exchange wrap data is invalid.");

    /* renamed from: ـॱ  reason: contains not printable characters */
    public static final CK f4874 = new CK(2010, MslConstants.ResponseCode.USER_REAUTH, "Invalid user ID token user data.");

    /* renamed from: ـᐝ  reason: contains not printable characters */
    public static final CK f4875 = new CK(7023, MslConstants.ResponseCode.FAIL, "Key exchange identity not found.");

    /* renamed from: ٴ  reason: contains not printable characters */
    public static final CK f4876 = new CK(2009, MslConstants.ResponseCode.USER_REAUTH, "Invalid user ID token signature.");

    /* renamed from: ٴॱ  reason: contains not printable characters */
    public static final CK f4877 = new CK(9001, MslConstants.ResponseCode.FAIL, "Error communicating with MSL entity.");

    /* renamed from: ߴ  reason: contains not printable characters */
    public static final CK f4878 = new CK(2007, MslConstants.ResponseCode.USER_REAUTH, "User ID token serial number is out of range.");

    /* renamed from: ߵ  reason: contains not printable characters */
    public static final CK f4879 = new CK(2018, MslConstants.ResponseCode.USER_REAUTH, "Error parsing user ID token user data.");

    /* renamed from: ߵॱ  reason: contains not printable characters */
    public static final CK f4880 = new CK(9999, MslConstants.ResponseCode.FAIL, "Special unit test error.");

    /* renamed from: ߺ  reason: contains not printable characters */
    public static final CK f4881 = new CK(2016, MslConstants.ResponseCode.USER_REAUTH, "No user ID token data found.");

    /* renamed from: ߺॱ  reason: contains not printable characters */
    private static final Set<Integer> f4882 = new HashSet();

    /* renamed from: ॱ  reason: contains not printable characters */
    public static final CK f4883 = new CK(2, MslConstants.ResponseCode.FAIL, "Computed hash does not match envelope hash.");

    /* renamed from: ॱʻ  reason: contains not printable characters */
    public static final CK f4884 = new CK(42, MslConstants.ResponseCode.FAIL, "Invalid algorithm parameters.");

    /* renamed from: ॱʼ  reason: contains not printable characters */
    public static final CK f4885 = new CK(44, MslConstants.ResponseCode.FAIL, "Error importing key.");

    /* renamed from: ॱʽ  reason: contains not printable characters */
    public static final CK f4886 = new CK(46, MslConstants.ResponseCode.FAIL, "Error in digest.");

    /* renamed from: ॱʾ  reason: contains not printable characters */
    public static final CK f4887 = new CK(2015, MslConstants.ResponseCode.USER_REAUTH, "The user ID token and user authentication data user identities do not match.");

    /* renamed from: ॱʿ  reason: contains not printable characters */
    public static final CK f4888 = new CK(2017, MslConstants.ResponseCode.USER_REAUTH, "Error parsing user ID token data.");

    /* renamed from: ॱˈ  reason: contains not printable characters */
    public static final CK f4889 = new CK(2012, MslConstants.ResponseCode.USER_REAUTH, "The entity is not associated with the user.");

    /* renamed from: ॱˉ  reason: contains not printable characters */
    public static final CK f4890 = new CK(2019, MslConstants.ResponseCode.USER_REAUTH, "User ID token is revoked.");

    /* renamed from: ॱˊ  reason: contains not printable characters */
    public static final CK f4891 = new CK(10, MslConstants.ResponseCode.FAIL, "Decryption not supported.");

    /* renamed from: ॱˋ  reason: contains not printable characters */
    public static final CK f4892 = new CK(16, MslConstants.ResponseCode.FAIL, "Signature not initialized or unable to process data/signature.");

    /* renamed from: ॱˌ  reason: contains not printable characters */
    public static final CK f4893 = new CK(3000, MslConstants.ResponseCode.FAIL, "Service token master token serial number does not match master token serial number.");

    /* renamed from: ॱˍ  reason: contains not printable characters */
    public static final CK f4894 = new CK(2020, MslConstants.ResponseCode.USERDATA_REAUTH, "User ID token is rejected by the application.");

    /* renamed from: ॱˎ  reason: contains not printable characters */
    public static final CK f4895 = new CK(17, MslConstants.ResponseCode.FAIL, "Error computing HMAC.");

    /* renamed from: ॱˑ  reason: contains not printable characters */
    public static final CK f4896 = new CK(3001, MslConstants.ResponseCode.FAIL, "Service token user ID token serial number does not match user ID token serial number.");

    /* renamed from: ॱͺ  reason: contains not printable characters */
    public static final CK f4897 = new CK(45, MslConstants.ResponseCode.FAIL, "Error exporting key.");

    /* renamed from: ॱـ  reason: contains not printable characters */
    public static final CK f4898 = new CK(3002, MslConstants.ResponseCode.FAIL, "Service token data invalid.");

    /* renamed from: ॱॱ  reason: contains not printable characters */
    public static final CK f4899 = new CK(9, MslConstants.ResponseCode.FAIL, "Encryption not supported.");

    /* renamed from: ॱᐝ  reason: contains not printable characters */
    public static final CK f4900 = new CK(15, MslConstants.ResponseCode.FAIL, "Verify not suppoprted.");

    /* renamed from: ॱᐧ  reason: contains not printable characters */
    public static final CK f4901 = new CK(3007, MslConstants.ResponseCode.FAIL, "Invalid service token data.");

    /* renamed from: ॱᐨ  reason: contains not printable characters */
    public static final CK f4902 = new CK(3003, MslConstants.ResponseCode.FAIL, "Service token is bound to an unknown master token.");

    /* renamed from: ॱᶥ  reason: contains not printable characters */
    public static final CK f4903 = new CK(3004, MslConstants.ResponseCode.FAIL, "Service token is bound to an unknown user ID token.");

    /* renamed from: ॱㆍ  reason: contains not printable characters */
    public static final CK f4904 = new CK(3006, MslConstants.ResponseCode.FAIL, "Service token user ID token serial number is out of range.");

    /* renamed from: ॱꓸ  reason: contains not printable characters */
    public static final CK f4905 = new CK(3005, MslConstants.ResponseCode.FAIL, "Service token master token serial number is out of range.");

    /* renamed from: ॱꜞ  reason: contains not printable characters */
    public static final CK f4906 = new CK(4000, MslConstants.ResponseCode.FAIL, "Unable to identify entity authentication scheme.");

    /* renamed from: ॱꜟ  reason: contains not printable characters */
    public static final CK f4907 = new CK(4001, MslConstants.ResponseCode.FAIL, "No factory registered for entity authentication scheme.");

    /* renamed from: ॱꞌ  reason: contains not printable characters */
    public static final CK f4908 = new CK(3009, MslConstants.ResponseCode.FAIL, "No service token data found.");

    /* renamed from: ॱﹳ  reason: contains not printable characters */
    public static final CK f4909 = new CK(3008, MslConstants.ResponseCode.FAIL, "Invalid service token signature.");

    /* renamed from: ॱﾞ  reason: contains not printable characters */
    public static final CK f4910 = new CK(4002, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Error parsing X.509 certificate data.");

    /* renamed from: ॱﾟ  reason: contains not printable characters */
    public static final CK f4911 = new CK(4005, MslConstants.ResponseCode.FAIL, "Entity not recognized.");

    /* renamed from: ᐝ  reason: contains not printable characters */
    public static final CK f4912 = new CK(6, MslConstants.ResponseCode.FAIL, "Plaintext contains incorrect padding.");

    /* renamed from: ᐝʻ  reason: contains not printable characters */
    public static final CK f4913 = new CK(4004, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "X.509 certificate verification failed.");

    /* renamed from: ᐝʼ  reason: contains not printable characters */
    public static final CK f4914 = new CK(4003, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Error encoding X.509 certificate data.");

    /* renamed from: ᐝʽ  reason: contains not printable characters */
    public static final CK f4915 = new CK(4006, MslConstants.ResponseCode.FAIL, "Entity used incorrect entity authentication data type.");

    /* renamed from: ᐝˊ  reason: contains not printable characters */
    public static final CK f4916 = new CK(53, MslConstants.ResponseCode.FAIL, "Unidentified signature envelope version.");

    /* renamed from: ᐝˋ  reason: contains not printable characters */
    public static final CK f4917 = new CK(51, MslConstants.ResponseCode.FAIL, "Invalid wrapping key.");

    /* renamed from: ᐝॱ  reason: contains not printable characters */
    public static final CK f4918 = new CK(18, MslConstants.ResponseCode.FAIL, "Error encrypting plaintext.");

    /* renamed from: ᐝᐝ  reason: contains not printable characters */
    public static final CK f4919 = new CK(48, MslConstants.ResponseCode.FAIL, "Unsupported JSON web encryption serialization.");

    /* renamed from: ᐧ  reason: contains not printable characters */
    public static final CK f4920 = new CK(47, MslConstants.ResponseCode.FAIL, "Unsupported key type or algorithm.");

    /* renamed from: ᐧॱ  reason: contains not printable characters */
    public static final CK f4921 = new CK(4007, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "RSA public key not found.");

    /* renamed from: ᐨ  reason: contains not printable characters */
    public static final CK f4922 = new CK(52, MslConstants.ResponseCode.FAIL, "Unidentified ciphertext envelope version.");

    /* renamed from: ᐨॱ  reason: contains not printable characters */
    public static final CK f4923 = new CK(4026, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Entity is rejected by the application.");

    /* renamed from: ᴵ  reason: contains not printable characters */
    public static final CK f4924 = new CK(4029, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "X.509 certificate is not yet valid.");

    /* renamed from: ᵎ  reason: contains not printable characters */
    public static final CK f4925 = new CK(4028, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "X.509 certificate is expired.");

    /* renamed from: ᵔ  reason: contains not printable characters */
    public static final CK f4926 = new CK(4025, MslConstants.ResponseCode.FAIL, "Entity is revoked.");

    /* renamed from: ᵢ  reason: contains not printable characters */
    public static final CK f4927 = new CK(4023, MslConstants.ResponseCode.FAIL, "Unsupported entity authentication data.");

    /* renamed from: ᶥ  reason: contains not printable characters */
    public static final CK f4928 = new CK(55, MslConstants.ResponseCode.FAIL, "Unsupported signature envelope version.");

    /* renamed from: ᶥॱ  reason: contains not printable characters */
    public static final CK f4929 = new CK(4034, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Invalid entity authentication data ciphertext.");

    /* renamed from: ᶫ  reason: contains not printable characters */
    public static final CK f4930 = new CK(4030, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "X.509 certificate is invalid.");

    /* renamed from: ⁱ  reason: contains not printable characters */
    public static final CK f4931 = new CK(4033, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Invalid entity authentication data siganture.");

    /* renamed from: ㆍ  reason: contains not printable characters */
    public static final CK f4932 = new CK(54, MslConstants.ResponseCode.FAIL, "Unsupported ciphertext envelope version.");

    /* renamed from: ㆍॱ  reason: contains not printable characters */
    public static final CK f4933 = new CK(4031, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "RSA private key not found.");

    /* renamed from: ꓸ  reason: contains not printable characters */
    public static final CK f4934 = new CK(57, MslConstants.ResponseCode.FAIL, "Unidentified algorithm.");

    /* renamed from: ꓸॱ  reason: contains not printable characters */
    public static final CK f4935 = new CK(4032, MslConstants.ResponseCode.FAIL, "Entity authentication data master token is not decrypted or verified.");

    /* renamed from: ꜝ  reason: contains not printable characters */
    public static final CK f4936 = new CK(4036, MslConstants.ResponseCode.FAIL, "Invalid entity authentication data master token.");

    /* renamed from: ꜞ  reason: contains not printable characters */
    public static final CK f4937 = new CK(58, MslConstants.ResponseCode.FAIL, "Error parsing signature envelope.");

    /* renamed from: ꜞॱ  reason: contains not printable characters */
    public static final CK f4938 = new CK(4037, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "ECC public key not found.");

    /* renamed from: ꜟ  reason: contains not printable characters */
    public static final CK f4939 = new CK(56, MslConstants.ResponseCode.FAIL, "Unidentified cipher specification.");

    /* renamed from: ꜟॱ  reason: contains not printable characters */
    public static final CK f4940 = new CK(4035, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "Entity authentication data signature verification failed.");

    /* renamed from: ꞌ  reason: contains not printable characters */
    public static final CK f4941 = new CK(60, MslConstants.ResponseCode.FAIL, "Invalid signature.");

    /* renamed from: ꞌॱ  reason: contains not printable characters */
    public static final CK f4942 = new CK(4038, MslConstants.ResponseCode.ENTITYDATA_REAUTH, "ECC private key not found.");

    /* renamed from: ﹳ  reason: contains not printable characters */
    public static final CK f4943 = new CK(62, MslConstants.ResponseCode.FAIL, "Unidentified JSON web key key operation.");

    /* renamed from: ﹳॱ  reason: contains not printable characters */
    public static final CK f4944 = new CK(5003, MslConstants.ResponseCode.FAIL, "Unable to identify user authentication scheme.");

    /* renamed from: ﹶ  reason: contains not printable characters */
    public static final CK f4945 = new CK(5007, MslConstants.ResponseCode.USERDATA_REAUTH, "Email or password is incorrect.");

    /* renamed from: ﹺ  reason: contains not printable characters */
    public static final CK f4946 = new CK(5005, MslConstants.ResponseCode.USERDATA_REAUTH, "Email or password is blank.");

    /* renamed from: ﾞ  reason: contains not printable characters */
    public static final CK f4947 = new CK(61, MslConstants.ResponseCode.FAIL, "Error deriving key.");

    /* renamed from: ﾞॱ  reason: contains not printable characters */
    public static final CK f4948 = new CK(5004, MslConstants.ResponseCode.FAIL, "No factory registered for user authentication scheme.");

    /* renamed from: ﾟ  reason: contains not printable characters */
    public static final CK f4949 = new CK(59, MslConstants.ResponseCode.FAIL, "Error encoding signature envelope.");

    /* renamed from: ﾟॱ  reason: contains not printable characters */
    public static final CK f4950 = new CK(5011, MslConstants.ResponseCode.USERDATA_REAUTH, "User authentication data user ID token is invalid.");

    /* renamed from: ۥ  reason: contains not printable characters */
    private final MslConstants.ResponseCode f4951;

    /* renamed from: ߴॱ  reason: contains not printable characters */
    private final int f4952;

    /* renamed from: ॱߴ  reason: contains not printable characters */
    private final String f4953;

    protected CK(int i, MslConstants.ResponseCode responseCode, String str) {
        synchronized (f4882) {
            if (f4882.contains(Integer.valueOf(i))) {
                throw new MslInternalException("Duplicate MSL error definition for error code " + i + ".");
            }
            f4882.add(Integer.valueOf(i));
        }
        this.f4952 = 100000 + i;
        this.f4951 = responseCode;
        this.f4953 = str;
    }

    /* renamed from: ˋ  reason: contains not printable characters */
    public int m4208() {
        return this.f4952;
    }

    /* renamed from: ˏ  reason: contains not printable characters */
    public String m4209() {
        return this.f4953;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CK)) {
            return false;
        }
        CK ck = (CK) obj;
        return this.f4952 == ck.f4952 && this.f4951 == ck.f4951;
    }

    public int hashCode() {
        return Integer.valueOf(this.f4952).hashCode() ^ this.f4951.hashCode();
    }
}
