package com.app.sportzfever.interfaces;

/**
 * Created by hemanta on 29-07-2017.
 */

public interface JsonApiHelper {

    String BASEURL = JsonApiHelper.BASEURL_LIVE;
    String BASEURL_LIVE = "https://sfscoring.sportzfever.com/";
   // String TESTURL = "http://sfscoring.betasportzfever.com/";
    String LOGIN = "sflogin";
    String GET_FEEDS = "getFeeds/";
    String GET_NOTIFICATION = "getNotifications/";
    String GET_FRIENDREQUEST = "getFriendRequests/";
    String GET_TEAMJOINREQUEST = "getAllTeamInvitation/";
    String GET_MATCHINVITATIONAVAILABILITY = "getMatchAndPrctiseInvitations/";
    String GET_UPCOMINGEVENTS = "getUpcomingEvent/";
    String GET_COMMENTS = "getComments/";
    String GET_LIKES = "getLikes/";
    String GET_SHARE = "getShares/";
    String GET_FRIENDLIST = "getFriendsList/";
    String GET_PASTMATCHES = "getAllPastMatches/";
    String GET_LIVEMATCHES = "getAllLiveMatches/";
    String GET_UPCOMINGMATCHES = "getAllUpcomingMatches/";
    String GET_RECENTCHAT = "getRecentChatData/";
    String SHAREFEED = "shareFeed";
    String UPDATESTATUS = "updateStatus";
    String DELETESTATUS = "deleteStatus/";
    String CREATESTATUS = "createStatus";
    String POSTCOMMENT = "comment";
    String SCORING = "scoring/";
    String UPDATECOMMENT = "updateComment";
    String DELETECOMMENT = "deleteComment/";
    String GET_JOINEDGROUPCHAT = "getJoinedGroups/";
    String SIGNUP = "sfSignUp";
    String ACCEPTREJECTMATCHCHALLENGEINVITATION = "RespondToMatchchallengeInvitation/";
    String ACCEPTREJECTSCORECHALLENGEINVITATION = "RespondToMatchScorerInvitation/";
    String ACCEPTFRIENDREQUEST = "confirmFriend";
    String RESPONDTOMATCHANDPRACTICEINVITATION = "RespondToMatchAndPractiseInvitation/";
    String RESPONDTOTEAMJOININVITATIONFROMTEAM = "RespondToTeamJoinInvitationFromTeam/";

    String SEND_MESSAGE = "postUserChat";
    String POST_GROUP_CHAT = "postGroupChat";
    String GET_CHATBOX_DATA = "getChatboxData/";
    String GET_GROUP_CHATBOX_DATA = "getGroupChatboxData/";
}
