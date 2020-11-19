function confirmation(success, action) {

	$('#acceptConfirm').attr("href", success);
	$('#title').html(action + ' Item');
	$('#ask').html('Are you sure you want to ' + action + ' this Item ?');
	$('#confirm').show();
}