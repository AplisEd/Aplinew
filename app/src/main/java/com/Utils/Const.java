package com.Utils;

import android.graphics.Color;



/**
 * Created by Cbc-03 on 05/23/17.
 */

public interface Const {



    String SNACKBAR_TEXT_COLOR = "#FFFFFF";
    String NOTE_DATA = "note_data";
    String NOTE_ID = "note_id";

    String DOSE_TYPE = "dose_type";
    String ARTICLE_ID = "article_id";
    // global topic to receive app wide push notifications
    int REQUEST_TAKE_GALLERY_VIDEO = 2221;
    int REQUEST_TAKE_GALLERY_IMAGE = 2222;
    int REQUEST_TAKE_GALLERY_DOC = 23;
    // broadcast receiver intent filters
    String NOTIFICATION_CODE = "notification_code";
    String NOTIFICATION_COUNT = "notification_count";
    String COMMENT_POST = "post_comment";
    String LIKE_POST = "post_like";
    String SHARE_POST = "post_share";
    String TAGGED_ON_POST = "post_tagged_on";
    String TAGGED_ON_COMMENT = "comment_tagged_on";
    String SPACE = "                                                                              ";
    String FOLLOWING_USER = "following";
    // id to handle the notification in the notification tray
    int NOTIFICATION_ID = 100;
    int TYPE_NIMBUS_LOGIN_OTP = 100;
    int NOTIFICATION_ID_BIG_IMAGE = 101;
    String IS_NOTIFICATION_BLOCKED = "is_notification_blocked";
    String SHARED_PREF = "ah_firebase";
    String FIREBASE_TOKEN_ID = "firebase_token_id";
    String PATH = "path";


    String TEST_SERIES_ID = "testseriesid";
    String TEST_SERIES_Name = "testseriesname";


    ////////////////////////////////
    String IMAGE_PATH = "image_path";
    String SIGNUP = "SIGNUP";
    String LOGIN = "LOGIN";
    String IS_USER_LOGGED_IN = "is_user_logged_in";
    String IS_USER_REGISTRATION_DONE = "is_user_reg_done";
    String IS_PHONE_VERIFIED = "is_phone_verified";
    String USER_LOGGED_IN = "user_logged_in";
    String MASTER_FEED_HIT_RESPONSE = "master_feed_hit_response";
    String MASTER_REGISTRATION_HIT_RESPONSE = "master_registration_hit_response";
    String DEVICE_TYPE_ANDROID = "1";
    String SOCIAL_TYPE_TRUE = "1";
    String SOCIAL_TYPE_FALSE = "0";
    String MODERATOR_SELECTED_STREAM = "moderator_selected_stream";
    String VERSION_CODE = "version_code";

    String STATUS = "status";
    String JWT = "jwt";
    String Jwt = "Jwt";
    String TRUE = "true";
    String FALSE = "false";
    String MESSAGE = "message";
    String DATA = "data";
    String STUDY_DATA = "study_data";
    String CloudFront_Key_Pair_Id = "CloudFront-Key-Pair-Id";
    String CloudFront_Signature = "CloudFront-Signature";
    String CloudFront_Expires = "CloudFront-Expires";
    String ERROR = "error";
    String TITLE = "title";
    String DESCRIPTION = "description";
    String CATEGORY = "category";
    String TITLE_DATA = "title_data";
    String COUNTER = "counter";
    String AUTH_CODE = "auth_code";// this auth code is to check the session expiration of the user logged in.
    String EXPIRY_AUTH_CODE = "100100";// this auth code is to check the session expiration of the user logged in.

    String NAME = "name";
    String ID = "id";
    String MY_COURSE = "my_course";
    String SUBJECT_ID = "subject_id";
    String CHAPTER_ID = "chapter_id";
    String EMAIL = "email";
    String PASSWORD = "password";
    String MOBILE = "mobile";
    String GENDER = "gender";
    String HLS = "hls";
    String DAMS_USERNAME = "dams_username";
    String DAMS_PASSWORD = "dams_password";


    //image from facebook
    String PICTURE = "picture";
    String URL = "image";
    String URL_IMAGE = "url";
    String VIDEO_CHANNEL = "video_channel";
    String COURSE_SECTION = "course_section";
    String FEED_SECTION = "feed_section";

    String IMGURL = "img_url";// image from google+
    String PICTUREURL = "pictureUrl"; //image from linkedin
    String PROFILE_PICTURE = "profile_picture"; //image from linkedin // dams local variable

    String IS_DAMS_USER = "isdamsuser";
    String DAMS_TOKEN = "dams_tokken";
    String USER_TOKEN = "user_tokken";
    String USER_TYPE = "user_type";
    String CITY = "city";

    String DEVICE_TYPE = "device_type";// 0 for none , 1 for android , 2 for IOS
    String DEVICE_TOKEN = "device_tokken";
    String manufacturer = "manufacturer";
    String model = "model";
    String version = "version";
    String ip = "ip";
    String DEVICETOKEN = "Devicetokken";

    String LOCATION = "location";
    String LAT = "lat";
    String LON = "lon";
    String LAST_KNOWN_LOCATION = "last_known_location";
    String IP_ADDRESS = "ip";
    String LAST_IP_ADDRESS = "ip_address";

    String IS_SOCIAL = "is_social";// 0 for no , 1 for yes
    String SOCIAL_TYPE = "social_type";// 0 for none , 1 for facebook , 2 for gmail , 3 for linkedin
    String SOCIAL_TOKEN = "social_tokken";
    String SOCIAL_TYPE_FACEBOOK = "1";
    String SOCIAL_TYPE_GMAIL = "2";
    String SOCIAL_TYPE_LINKEDIN = "3";

    int NIMBUS_LOGIN_TYPE = 1;
    int NIMBUS_SIGNUP_TYPE = 2;
    String OTP = "otp";
    String FRAG_TYPE = "frag_type";
    String INTRO_DATA = "intro_data";
    String SKIP_UNIT = "skip_unit";
    String SKIP_CHAPTER = "skip_chapter";
    String RESET_PASS = "reset_pass";
    String TYPE = "type";
    String TYPE_ID = "type_id";
    String PAGE = "PAGE";
    String PEOPLE_LIST_FEEDS = "people_list_feed";
    String PEOPLE_LIST_COMMONS = "people_list_common";
    String PEOPLE_LIST_FEEDS_COMMONS = "people_list_feeds_common";
    String COMMON_PEOPLE_TYPE = "common_people_type";
    String YOUTUBE_ID = "youtube_id";
    String VIEW_TYPE = "view_type";

    //CONSTANTS FOR THE FRAGMENTS
    String CHANGEPASSWORD = "changepassword";
    String FORGETPASSWORD = "forgetpassword";
    String MOBILEVERIFICATION = "mobileverification";
    String OTPVERIFICATION = "otpverification";
    String REGISTRATION = "registration";
    String COURSES = "Courses";
    String ALLCOURSES = "All Courses";
    String LEADERBOARD = "My Scorecard";
    String REWARDPOINTS = "Reward Points";
    String MYCOURSES = "My Courses";
    String STUDY = "study";
    String Doubts = "Doubts";
    String FEEDS = "Feeds";
    String SPECIALITIES = "Specialities";
    String SAVEDNOTES = "Saved Notes";
    String FEEDBACK = "Feedback";
    String VIDEOS = "Videos";
    String PRACTICE = "Practice";
    String STUDY_TITLE = "study_title";


    //IBT
    String COURSE_SELECTION = "course_selection";
    String CHANGELANGUAGE = "changelanguage";
    String INTRO = "intro";
    String SIGNIN = "signin";


    String EXAM_CATEGORY = "examcategory";
    String RATEUS = "Rate Us";
    String APPSETTING = "App Settings";
    String TERMS = "Terms And Condition";
    String PRIVACY = "Privacy Policy";
    String TERMSURL = "http://emedicoz.com/production_dams/terms_and_conditions.php";
    String PRIVACYURL = "http://emedicoz.com/production_dams/privacy_policy.php";
    String LOGOUT = "Logout";
    String PROFILE = "PROFILE";
    String COMMENT = "comment";
    String REWARD_TRANSACTION_FRAGMENT = "reward_transaction_fragment";
    String COMMENT_LIST = "comment_list";
    String NOTIFICATION = "notification";
    String YOUTUBE = "youtube";
    String VIMEO_ID = "vimeo_id";
    String INVITEDBY = "invitedBy";
    String POSTID_REFFERED = "postId";
    String REFER_CODE = "refer_code";

    String SUBTITLECOURSE = "subtitlecourse";
    String SUBTITLE = "subtitle";
    String SUBTITLE1 = "sub_title1";
    String CREATED_INSTANCE = "CREATED_INSTANCE";
    String FEED_PREFERENCE = "feedpreference";
    String DOUBT_PREFERENCE = "doubtpreference";
    String SEARCHED_QUERY = "searched_query";
    String COURSE_SEARCHED_QUERY = "course_searched_query";
    String IS_PROFILE_CHANGED = "is_profile_changed";
    String IS_PROFILE_PIC = "is_profile_pic";

    //HEADER INFORMATION
    String DEVICE_ID = "device_id";
    String SESSION_ID = "session_id";
    String SETUP_VERSION = "setup_version";
    String DEVICE_INFO = "device_info";

    //CONSTANTS FOR THE FRAGMENT MANAGER TO ADD TO THE STACK AND RETREIVE
    String REGISTRATIONFRAGMENT = "RegistrationFragment";
    String SUBSTREAMFRAGMENT = "subStreamFragment";
    String SPCIALISATIONFRAGMENT = "specializationFragment";
    String INTERESTEDCOURSESFRAGMENT = "CourseInterestedInFragment";

    String NO_INTERNET = "Please check your internet connection.";

    //FEEDS CONSTANTS
    String COMMENT_ID = "comment_id";
    String POST_ID = "post_id";
    String AREA = "area";
    String POST_TYPE = "post_type";
    String MESSAGE_TARGET = "message_target";
    String PARENT_ID = "parent_id";

    String POST_TEXT_TYPE_TEXT = "text";
    String POST_TEXT_TYPE_YOUTUBE_TEXT = "youtube_text";

    String POST_TYPE_LETS_TALK = "user_post_type_lets_talk";
    String POST_TYPE_LIVE_STREAM = "user_post_type_livestream";
    String POST_TYPE_MCQ = "user_post_type_mcq";
    String POST_TYPE_QUIZ = "user_post_type_quiz";
    String POST_TYPE_VIDEOS = "user_post_type_video";
    String POST_TYPE_NORMAL = "user_post_type_normal";
    String POST_TYPE_PEOPLEYMK = "user_post_type_people";
    String POST_TYPE_MEET_THE_EXPERT = "user_post_type_expert_people";
    String POST_TYPE_SUGGESTED_VIDEOS = "user_post_type_suggested_videos";
    String POST_TYPE_SUGGESTED_COURSES = "user_post_type_suggested_courses"; // need to change
    String POST_TYPE_BANNER = "user_post_type_banner";
    String POST_TYPE_DOUBT = "user_post_type_doubt";


    String POST_COMMENT = "comment";

    String POST_FRAG = "post_frag";
    String POST_MENTOR = "post_mentor";
    String COMMON_PEOPLE_LIST = "like_list";
    String COMMON_PEOPLE_VIEWALL = "list_view_all";
    String COMMON_EXPERT_PEOPLE_VIEWALL = "list_expert_view_all";
    String COMMON_DOUBT_EXPERT_VIEWALL = "list_doubt_expert_view_all";
    String FOLLOW_THE_EXPERT_FIRST = "follow_the_expert_first";

    //LINKEDIN AUTHNETICATIONS
    String LINKEDIN_CONSUMER_KEY = "77wyaocg0phxre";
    String LINKEDIN_CONSUMER_SECRET = "O84Zy3TX1RnnRuT1";
    String OAUTH_CALLBACK_URL = "http://www.appsquadz.com/accept";
    String IS_CHROMCAST_RUNNING = "is_chromcast_running";
    //POST MCQ CONSTANTS
    String USER_ID = "user_id";// primary id of logged in user
    String TEST_SEGMENT_ID = "user_id";// primary id of logged in user
    String USERID = "user_id";// primary id of logged in user
    String USER_FOR = "user_for";
    String Skip_unit = "skip_unit";
    String skip_chapter = "skip_chapter";
    String COLOR_CODE = "color_code";// primary id of logged in user
    String LAST_POST_ID = "last_post_id";//last post id for pagination
    String LAST_FOLLOW_ID = "last_follow_id";//last post id for followers/ following
    String LAST_LIKE_ID = "last_id";//last like id for pagination
    String TAG_ID = "tag_id";//to add tag related search
    String SEARCH_TEXT = "search_text";//to add the text search for feeds
    String SEARCH_CONTENT = "search_content";//to add the text search for videos
    String LAST_COURSE_ID = "last_course_id";//last course id for search course pagination
    String LAST_ACTIVITY_ID = "last_activity_id";//last notification id for pagination
    String LAST_COMMENT_ID = "last_comment_id";//last comment id for pagination
    String LAST_REVIEW_ID = "last_review_id";//last review id for pagination on Instructor
    String LAST_ID = "last_id";//last review id for pagination on courseReviews // also to be used for the pagination in getting the list of reward points
    String LAST = "last";
    String QUESTION = "question";
    String ANSWER_ONE = "answer_one";
    String ANSWER_TWO = "answer_two";
    String ANSWER_THREE = "answer_three";
    String ANSWER_FOUR = "answer_four";
    String ANSWER_FIVE = "answer_five";
    String RIGHT_ANSWER = "right_answer";
    String TAG_VIDEO = "tag_video";
    String QUIZSTATUS = "quiz_status";
    String RESUME = "resume";
    String FINISH = "finish";

    String COURSE_LIST = "course_list";

    String LINK = "link";
    String IMAGE = "image";
    String VIDEO = "video";

    //Todo course File Type for Download & Delete purpose //
    String VIDEO_Courses = "video";
    String PDF = "pdf";
    String PPT = "ppt";
    String DOC = "doc";
    String EPUB = "epub";
    String TEST = "test";
    String XLS = "xls";


    String IMAGES = "images";
    String POSITION = "position";
    String FILE = "file";
    String TAGLIST_OFFLINE = "taglist_offline";
    String TAG_PEOPLE = "tag_people";
    String REMOVE_TAG_PEOPLE = "remove_tag_people";
    String POST_TAG = "post_tag";
    String DELETE_META = "delete_meta";
    String YOUTUBE_VIDEO = "youtube_video";

    String TEXT = "text";
    String VIDEO_LINK = "video_link";
    String VIDEO_STREAM = "stream";
    String VIDEO_LIVE = "live";

    //REGISTRATION COSTANTS
    String MASTER_ID = "master_id";
    String MASTER_ID_LEVEL_ONE = "master_id_level_one";
    String MASTER_ID_LEVEL_TWO = "master_id_level_two";
    String OPTIONAL_TEXT = "optional_text";
    String INTERESTED_COURSE = "interested_course";
    String COUNTRY_CODE = "c_code";

    //VIDEOS COSTANTS
    String VIDEO_ID = "video_id";
    String LAST_VIDEO_COMMENT_ID = "last_comment_id";
    String SUB_CAT = "sub_cat";
    String SORT_BY = "sort_by";
    String LAST_VIDEO_ID = "last_video_id";
    String PAGE_SEGMENT = "page_segment";
    String VIEWS = "views";
    String MAIN_CAT_ID = "main_cat_id";

    String OPTION = "option";
    String OPTION_VALUE = "option_value";
    String RESULT_AS = "resultAs";
    String LEARNERS = " Learners";
    String LEARNER = " Learner";
    String SEEALL_COURSE = "seeall_course_list";
    String COURSE_CATEGORY = "course_categry";
    String CATEGORY_ID = "cat_id";
    String COURSE_ID = "course_id";
    String COURSE_PRICE = "course_price";
    String SINGLE_COURSE = "singel_course";
    String SINGLE_STUDY = "single_study";
    String TEST_TYPE_ID = "test_type_id";
    String TEST_MAIN_ID = "test_main_id";
    String MULTIPLE_STUDY = "multiple_study";
    String MULTIPLE_STUDY_INTRO = "multiple_study_intro";
    String RATING = " Ratings";
    String COURSE_DES = "course_des";
    String REVIEWS = " Reviews";
    String INSTR_REVIEWS = " Instr_Reviews";
    String REVIEW = " Review";
    String FAQ = "faq";
    String INSTR = "instructor";
    String INSTR_ID = "instructor_id";
    String CURRICULUM = "curriculum";
    String RATINGS = "rating";
    String RESULT_SCREEN = "resultscreen";
    String COURSE_INIT_PAYMENT_TOKEN = "pre_transaction_id";
    String COURSE_FINAL_PAYMENT_TOKEN = "post_transaction_id";
    String CHECK_SUM = "checksumhash";
    String TESTSERIES_ID = "test_series_id";
    String TESTSEGMENT_ID = "test_segment_id";
    String TESTSERIES = "test_series";
    String first_attempt = "first_attempt";

    String TIME_SPENT = "time_spent";
    String TIME_REMAIN = "time_remain";
    String QUESTION_JSON = "question_dump";

    String RESUME_WINDOW = "resumeWindow";
    String RESUME_POSITION = "resumePosition";

    String BANNER_ID = "banner_id";
    String REASON_ID = "reason_id";
    String IS_PAYMENT_DONE = "is_payment_done";
    String COURSE_INVOICE = "course_invoice";
    String COUPON_CODE = "coupon_code";
    String ANSWER = "answer";
    String ANSWERS = "answers";
    String MCQ_ID = "mcq_id";


    //PAYTM CONSTANTS FOR EMEDICOZ PAYMENT CALLS
    String CALLBACK_URL = "CALLBACK_URL";
    String WEBSITE = "WEBSITE";
    String TXN_AMOUNT = "TXN_AMOUNT";
    String CHANNEL_ID = "CHANNEL_ID";
    String CUST_ID = "CUST_ID";
    String INDUSTRY_TYPE_ID = "INDUSTRY_TYPE_ID";
    String ORDER_ID = "ORDER_ID";
    String SERVERTYPE = "SERVER";
    String MID = "MID";

    String CHECKSUMHASH = "CHECKSUMHASH";

    String ADDTO_MYCOURSE = "Add to my Course";
    String ALL_REVIEWS = "All Reviews";
    String SERVER = "SERVER";
    String ORDERID = "ORDERID";
    String SOLUTION = "Solution";
    String RE_ATTEMPT = "re_attempt";
    String POINTS_RATE = "points_rate";
    String POINTS_USED = "points_used";
    String TAX = "tax";


    String TOTAL_TIME = "total_time";
    String VIEW_TIME = "view_time";
    String FileID = "file_id";
    String TIME = "time";
    String INFO = "info";
    String ORIGIN = "origin";

    String EXAM_CATEGORY_NAME = "exam_cat_name";
    String NEW_POST_TYPE = "new_post_type";
    int NEW_POST_TYPE_MCQ = 1;
    int POST_TYPE_QUERY = 4;
    int POST_TYPE_SHARE_INFO = 5;
    int POST_TYPE_SHARE_EXPERIENCE = 3;
    int POST_TYPE_VIDEO = 2;
    int POST_AREA = 1;
    int CONCEPT_AREA = 2;
    String STUDY_DETAIL = "study_detail";
    String CONCEPT = "study_concept";
    String STUDY_VIDEOS = "study_videos";
    String STUDY_QUIZ = "study_quiz";
    String DAILYDOSE_HOME = "daily_dose_home";
    String DAILYDOSE_TITLE = "daily_dose_title";
    String EXAM_PREF_TITLE = "exam_pref_title";
    String VIDEOS_HOME = "videos_home";
    String VIDEOS_TITLE = "videos_title";
    String CURRENT_AFFAIR = "current_affair";
    String SEE_ALL_VIDEOS = "see_all_videos";
    String VIDEO_CAT = "video_category";
    String VIDEO_CAT_NAME = "video_category_name";
    int VIDEOS_REQUEST_CODE = 1002;
    String STUDY_FRAG = "study_fragment";
    String STUDY_CONCEPTS = "study_concepts";
    String COURSE_DATA = "course_data";
    String VIDEO_LECTURE = "video_lecture";
    String LANGUAGE = "language";
    String HINDI = "hi";
    String ENGLISH = "en";
    java.lang.String THEME = "theme";
    String CHOOSE_SUB_EXAM = "choose_sub_exam";
    String NIGHT_MODE = "night_mode";
    String MY_PREF_FRAG = "my_pref";
    String USER = "user";
    String APP_LANGUAGE = "app_lang";
    String ISFIRSTPOST = "first_post";
    String FLAG = "flag";
    String PREFERENCE = "prefrences";
    String SUBCATPREF = "subCatsPrefs";
    String COURSE_TYPE = "course_type";
    String CAT_ID = "main_cat";
    String CURRENCY_INDIAN = "currency_indian";

    String REVIEWOFDAY = "review_of_day";
    String QUIZ = "quiz";
    String QUIZ_ID = "quiz_id";
    String RESPONSE = "response";
    String POSTVOCAB = "user_post_type_vocab";
    String POSTARTICLE = "user_post_type_article";
    String POSTAFFAIR = "user_post_type_current_affair";
    String POSTREVIEW = "user_post_type_review";
    String POSTQUIZ = "user_post_type_quiz";
    String POSTSEARCHING = "?post_searching=";
    String VOCAB = "vocab";
    String URL_KEY = "url_key";
    String CONCEPTS = "concepts";
    String CHEATNOTE = "CHEATNOTE";
    String QUESTIONSET = "Question Set";
    String CONCEPTT = "concept";
    String VIMEO_VIDEO_STREAM = "vimeo_video_stream";
    String CHOOSE_CHAPTER = "choose_chapter";
    String SLIDER_ID = "slider_id";
    String SEGMENT_TYPE = "section_type";
    String SEGMENT_ID = "segment_id";
    String SECTION_ID = "section_id";
    String CATEGORY_TO_POST = "cat_to_post";
    String SUBCATPREF_TO_POST = "sub_cat_to_post";
    String SUB_CAT_ID = "sub_cate_id";
    String STRING_TO_MATCH = "string_to_match";
    String ARTICLE_DETAIL = "article_detail";


    public static final int REQUEST_IMAGES = 1;
    public static final int REQUEST_IMAGE_CAPTURE = 2;
    String EXAM_TO_POST = "exam_to_post";

    String SUB_EXAM_TO_POST = "sub_exam_to_post";
    String VIA = "via";
    String RELATED_VIDEO_ID = "related_video_id";
    String FAVOURITE = "favourite";
    String SUB_CAT_LIST = "sub_cat_list";
    String SUBJECT = "subject";

    String IS_MENTOR = "?get_mentor_post=1";
    String POST_CHECK = "post_check";
    String SUGGESTED_POST = "suggested_post";
    String SUGGESTED_ARRAYLIST = "suggested_arraylist";
    String CONGRATULATIONS = "congratulations";
    String SELECTED_STREAM = "stream";
    String ATTEMPT = "Attempt";
    String ATTEMPTS = "Attempts";
    String IS_SHOWCASE = "is_showcase";
    int HINDI_CODE = 2;
    int ENGLISH_CODE = 1;
    String LANG = "Lang";
    String COURSESLIST = "courseList";
    String LAYER = "layer";
    String LIST = "list";
    String PRACTICES = "practice";
    String MAIN_ID = "main_id";
    String EXAMPREP = "examprep";
    String EXAMPREPLAST = "exampreplast";
    String CONTENT_TYPE = "content_type";
    String BOOK = "book";
    String INTRODUCTION = "introduction";
    String TEST_THIRD = "test_third";
    String SUB_ID = "sub_id";
    String VIDEO_LIST = "video_list";
    String TEST_TYPE = "test_type";
    String TOPIC_ID = "topic_id";
    String VIDEOEXAMPREP = "videoexamprep";
    String POINT = "point";
    String POINTS = "points";
    String PRACTICE_ID = "practice_id";
    String SLIDER = "slider";
    String SLIDER2 = "slider2";
    String RED = "red";
    String GRAY = "gray";

    String PROCKET_PAYMENT_STATUS = "procket_payment_status";
    String PAYMNET_SUCCESSFUL = "paymentSuccessful";
    String PAYMENT_FAILED = "paymentFailed";

    String SHOW_SUGGESTED_VIDEO = "show_suggested_video";
    String SUCCESS = "success";
    String RESULT = "result";
    String PRIVACY_POLICY = "privacy_policy";
    String UNIT_CHEPTER = "unit_chepter";
    String TOPIC_SUBTOPIC = "topic_subtopic";
    String UNIT_DATA = "unit_data";

    String TOPIC_DATA = "topic_data";
    String COURSE_DETAIL = "course_detail";
    String SUBTOPIC_ID = "sub_topic_id";
    String data_required = "data_required";
    String UNIT_ID = "unit_id";
    String SUBJECT_ID1 = "sub_id";


    // Doubts section
    String DOUBT_PLAN_DATA = "doubt_plan_data";
    String EXPERT_LIST = "experts_list";
    String IS_SUBSCRIBED_ANY_PLAN = "is_subscribed_plan";
    String PLANS = "plans";
    int POST_TYPE_DOUBT_INT = 6;
    String POST_TEXT_TYPE_DOUBT = "user_post_type_doubt";
    String DOUBT_PLAN_PRICE_id = "doubt_plan_price_id";
    String PAYMENT_FOR="payment_for";
    String GET_DOUBT_FOR_EXPERT="?get_doubt_for_expert=";
    String GET_DOUBT_FOR_ME="?get_my_doubts=";
    String GET_DOUBT_ON_STATUS="&get_doubt_on_status=";
    String POST_ADDITIONAL_JSON="additional_json";
    String TOTAL_SOLVED_DOUBTS = "total_solved_doubt";
    String TOTAL_UNSOLVED_DOUBTS = "total_unsolved_doubt";
    String DOUBT_EXPERTS = "doubt_experts";
    String IS_DOUBT_EXPERT = "is_doubt_expert";
    String ROLL_NO = "roll_no";
    String COMPAIGN_ID = "campaign_id";


    String[] chromCastAppPackages=new String[]{"com.google.android.gms"};
    String COOKIE_DATA = "cookie_data";
    String FINAL_PRICE_VALUE="final_price_value";
    int PAYMENT_REQUEST_CODE = 1234;
    String FIREBASE_TOKEN="firebase_token";
}

