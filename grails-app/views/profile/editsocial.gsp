<html>

  <head>
    <meta name="layout" content="${grailsApplication.config.nimble.layout.application}"/>
    <title>Profile | Edit Social Services</title>

    <nh:growl/>

  <link rel="stylesheet" href="${resource(dir: pluginContextPath, file: '/css/profile.css')}"/>

</head>

<body>
  <div class="container">
    <div class="profile">

      <g:render template="/templates/nimblesocial/profile/left" model="[user:user, profile:user.profile]" />

      <div class="main edit">
        <g:render template="/templates/nimblesocial/profile/banner" model="[user:user, profile:user.profile]" />

        <div class="section">
          <h3>Social Services</h3>

          <div id="currentsocialaccounts">
            <g:if test="${user.profile.socialAccounts?.size() > 0}">
              <p>This account currently has the following social services linked to it</p>
            </g:if>
            <g:else>
              <p>This account does not currently link to any social services</p>
            </g:else>

            <g:each in="${user.profile.socialAccounts}" var="account" status="i">
              <g:render template="/templates/nimblesocial/profile/socialmedia" model="[account:account, remove:true]"/>
              <g:render template="/templates/nimblesocial/social/edit/${account.service.details.name.toLowerCase()}" model="[account:account]"/>
            </g:each>
          </div>

          <div id="newsocialrmessageerror">
          </div>
          <div class="add">
            <h5>Link a new social service to this account</h5>
            <n:socialimg name="facebook" size="24"/>
            <n:socialimg name="twitter" size="24"/>
            <n:socialimg name="blogger" size="24"/>
            <n:socialimg name="digg" size="24"/>
            <n:socialimg name="myspace" size="24"/>
            <n:socialimg name="delicious" size="24"/>
            <n:socialimg name="flickr" size="24"/>
            <n:socialimg name="lastfm" size="24"/>
            <n:socialimg name="reddit" size="24"/>
            <n:socialimg name="wordpress" size="24"/>
            <n:socialimg name="youtube" size="24"/>
          </div>

        </div>

      </div>
    </div>
  </div>
</body>

</html>
