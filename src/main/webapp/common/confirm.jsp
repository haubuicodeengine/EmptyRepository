<div id="confirm" class="modal">
	<form class="modal-content">
		<div class="container-model">
			<div class="title-popup">
				<span
					onclick="document.getElementById('confirm').style.display='none'"
					class="close" title="Close Modal">&times;</span>
				<h1 id="title" class="action-confirm"></h1>
			</div>

			<div class="">
				<p id="ask" class="ask"></p>

				<div class="clearfix flex-around">
					<div>
						<a id="cancelConfirm" href="#"
							onclick="document.getElementById('confirm').style.display='none'">
							<button type="button"
								class="btn-warning btn cancelbtn confirm-btn">
								No
							</button>
						</a>
					</div>
					<div>
						<a id="acceptConfirm" href="#">
							<button type="button" class="btn-pink btn acceptbtn confirm-btn">
								Yes
							</button>
						</a>
					</div>
				</div>
			</div>
		</div>
	</form>
</div>