function confirmation(success, action) {

	$('#acceptConfirm').attr("href", success);
	$('#title').html(action + ' item');
	$('#ask').html('Are you sure you want to ' + action + ' this item ?');
	$('#confirm').show();
}