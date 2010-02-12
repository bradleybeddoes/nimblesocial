<%@ page import="grails.plugins.nimble.auth.CorePermissions" %>
<script type="text/javascript">
    function clearStatus() {
    var dataString = "id=" + ${profile.owner.id.encodeAsHTML()};
    $.ajax({
      type: "POST",
      url: "${createLink(action:'clearstatus')}",
      data: dataString,
      success: function(res) {
        $("#activestatus").hide().empty();
      },
      error: function (xhr, ajaxOptions, thrownError) {
        growl("error", "There was an error updating your status");
      }
    });
  }
</script>

<g:if test="${profile.currentStatus != null}">
  ${profile.currentStatus.status}
  <span class="statuscreated"><g:formatDate format="E dd/MM/yyyy" date="${profile.currentStatus.dateCreated}"/></span>

  <g:if test="${clear}">
    <n:hasPermission target="${CorePermissions.editPermission}:$profile.owner.id">
      <span class="clearstatus"><a onclick="clearStatus();" class="icon icon_delete">clear</a></span>
    </n:hasPermission>
  </g:if>

</g:if>
