$(document).ready(function() { 
	init();

	let base_url = 'http://localhost:8080/';
	let cont = $('#content');


	// ------------------------------------------------------------
	// Users

	// List of users
	$(document).on('click', '#users', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));
		let url = base_url+'users';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';
				if (data.length>0) {
					cont.removeClass().addClass("users");

					contentHtml += '<table>';
					contentHtml += '<tr><th>ID</th><th>Name</th><th>Address</th><th></th></tr>';
					data.forEach(function(el) {
						contentHtml += '<tr><td>'+ el.id +'</td>' +
							'<td>'+ el.name +'</td>' +
							'<td>'+ el.address +'</td>' +
							'<td><a href="#" id="deleteUser" idUser="'+el.id+'">Delete</a></td>' +
						'</tr>';
					});
					contentHtml += '</table>';
				}
				cont.html(contentHtml);

			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// add-user form
	$(document).on('click', '#addUserForm', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));

		let contentHtml = '';
		contentHtml += '<form id="userForm">';
			contentHtml += '<div>';
				contentHtml += '<lavel>ID </lavel>';
				contentHtml += '<input type="text" name="ID" value="">';
			contentHtml += '</div>';
			contentHtml += '<div>';
				contentHtml += '<lavel>Name </lavel>';
				contentHtml += '<input type="text" name="name" value="">';
			contentHtml += '</div>';
			contentHtml += '<div>';
				contentHtml += '<lavel>Address </lavel>';
				contentHtml += '<input type="text" name="address" value="">';
			contentHtml += '</div>';
		contentHtml += '<input type="button" id="addUser" name="addUser" value="Add">';
		contentHtml += '</form>';
		cont.html(contentHtml);

	});

	// add user
	$(document).on('click', '#addUser', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));
		let url = base_url+'users';

		let formData = {
			id : $('#userForm input[name=ID]').val(),
			name : $('#userForm input[name=name]').val(),
			address : $('#userForm input[name=address]').val()
		};

		$.ajax({
			url: url,
			method: 'POST',
			data: JSON.stringify(formData),
			contentType: 'application/json',
			beforeSend: function() {
				cont.html('loading...');
			},
			success: function success(data) {
				$('#users').trigger("click");
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// delete User
	$(document).on('click', '#deleteUser', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('users'));

		let url = base_url+'users/'+$(this).attr("idUser");

		$.ajax({
			url: url,
			method: 'DELETE',
			contentType: 'application/json',
			beforeSend: function() {
				cont.html('loading...');
			},
			complete: function () {
				$('#users').trigger("click");
			},
			success: function success(data) {},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Users
	// ============================================================



	// ------------------------------------------------------------
	// Questions

	$(document).on('click', '#questions', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('questions'));
		let url = base_url+'questions';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';

				if (data.results.length>0) {
					cont.removeClass().addClass("questions");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Question</th>' +
						'<th>Correct answer</th>' +
						'<th>Incorrect answers</th>' +
						'<th>Category</th>' +
						'<th>Difficulty</th>' +
						'<th>Type</th>' +
					'</tr>';
					data.results.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.question +'</td>';
						contentHtml += '<td>'+ el.correct_answer +'</td>';
						contentHtml += '<td>';
						el.incorrect_answers.forEach(function (ia) {
							contentHtml += '<span>'+ia+'</span><br/>';
						});
						contentHtml += '</td>';
						contentHtml += '<td>'+ el.category +'</td>';
						contentHtml += '<td>'+ el.difficulty +'</td>';
						contentHtml += '<td>'+ el.type +'</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Questions
	// ============================================================




	// ------------------------------------------------------------
	// Quizzes

	$(document).on('click', '#quiz', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('quiz'));
		let url = base_url+'quiz';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				// console.log(data);
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("quiz");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Id</th>' +
						'<th>Start date</th>' +
						'<th>Amount</th>' +
						'<th>User</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.start_date +'</td>';
						contentHtml += '<td>'+ el.amount +'</td>';
						contentHtml += '<td>';
							contentHtml += '<b>Id:</b> <span>'+el.user.id+'</span><br/>';
							contentHtml += '<b>Name:</b> <span>'+el.user.name+'</span><br/>';
							contentHtml += '<b>Address:</b> <span>'+el.user.address+'</span><br/>';
						contentHtml += '</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});


	// add-quiz form
/*	$(document).on('click', '#addQuizForm', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('quiz'));

		let contentHtml = '';
		contentHtml += '<form id="userForm">';
		contentHtml += '<div>';
		contentHtml += '<lavel>ID </lavel>';
		contentHtml += '<input type="text" name="ID" value="">';
		contentHtml += '</div>';
		contentHtml += '<div>';
		contentHtml += '<lavel>Name </lavel>';
		contentHtml += '<input type="text" name="name" value="">';
		contentHtml += '</div>';
		contentHtml += '<div>';
		contentHtml += '<lavel>Address </lavel>';
		contentHtml += '<input type="text" name="address" value="">';
		contentHtml += '</div>';
		contentHtml += '<input type="button" id="addUser" name="addUser" value="Add">';
		contentHtml += '</form>';
		cont.html(contentHtml);

	});*/
	$(document).on('click', '#quizes', function (e) {
    		e.preventDefault();
    		$('#sub-menu').html(getSubMenu('quizes'));
    		let url = base_url+'quizes';

    		$.ajax({
    			url: url,
    			method: 'GET',
    			dataType: 'json',
    			beforeSend: function () {
    				cont.html('loading...');
    			},
    			complete: function () {},
    			success: function success(data) {
    				let contentHtml = '';
    				if (data.length>0) {
    					cont.removeClass().addClass("quizes");

    					contentHtml += '<table>';
    					contentHtml += '<tr><th>ID</th><th>Start Date</th><th>Amount</th><th></th></tr>';
    					data.forEach(function(el) {
    						contentHtml += '<tr><td>'+ el.id +'</td>' +
    							'<td>'+ el.start_date +'</td>' +
    							'<td>'+ el.amount +'</td>' +
    							'<td><a href="#" id="deleteUser" userId="'+el.id+'">Delete</a></td>' +
    						'</tr>';
    					});
    					contentHtml += '</table>';
    				}
    				cont.html(contentHtml);

    			},
    			error: function error(jqXHR, textStatus, errorThrown) {
    				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
    			}
    		});

    	});
	$(document).on('click', '#addQuizForm', function (e) {
       e.preventDefault();
       $('#sub-menu').html(getSubMenu('quizes'));
       let contentHtml = '';
       contentHtml += '<form id="quizForm">';
       contentHtml += '<div>';
       contentHtml += '<lavel>ID </lavel>';
       contentHtml += '<input type="text" name="ID" value="">';
       contentHtml += '</div>';
       contentHtml += '<div>';
       contentHtml += '<lavel>Start Date </lavel>';
       contentHtml += '<input type="text" name="start_date" value="">';
       contentHtml += '</div>';
       contentHtml += '<div>';
       contentHtml += '<lavel>Amount </lavel>';
       contentHtml += '<input type="text" name="amount" value="">';
       contentHtml += '</div>';
       contentHtml += '<input type="button" id="addQuiz" name="addQuiz" value="Add">';
       contentHtml += '</form>';
       cont.html(contentHtml);
    });

$(document).on('click', '#addQuiz', function (e) {
   e.preventDefault();
   $('#sub-menu').html(getSubMenu('quizes'));
   let url = base_url+'quizes';
   let formData = {
      id : $('#quizForm input[name=ID]').val(),
      start_date : $('#quizForm input[name=start_date]').val(),
      amount : $('#quizForm input[name=amount]').val()
   };
   $.ajax({
      url: url,
      method: 'POST',
      data: JSON.stringify(formData),
      contentType: 'application/json',
      beforeSend: function() {
         cont.html('loading...');
      },
      success: function success(data) {
         $('#').trigger("click");
      },
      error: function error(jqXHR, textStatus, errorThrown) {
         console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
      }
   });
});
	// Quizzes
	// ============================================================



	// ------------------------------------------------------------
	// Tasks

	$(document).on('click', '#tasks', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('tasks'));
		let url = base_url+'tasks';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				// console.log(data);
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("tasks");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Id</th>' +
						'<th>Text</th>' +
						'<th>Day</th>' +
						'<th>Reminder</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.text +'</td>';
						contentHtml += '<td>'+ el.day +'</td>';
						contentHtml += '<td>'+ el.reminder +'</td>';
						contentHtml += '</tr>';
					});
					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// Tasks
	// ============================================================



	// ------------------------------------------------------------
	// My quiz

	$(document).on('click', '#myquiz', function (e) {
		e.preventDefault();
		$('#sub-menu').html(getSubMenu('myquiz'));
		let url = base_url+'myquiz';

		$.ajax({
			url: url,
			method: 'GET',
			dataType: 'json',
			beforeSend: function () {
				cont.html('loading...');
			},
			complete: function () {},
			success: function success(data) {
				let contentHtml = '';

				if (data.length>0) {
					cont.removeClass().addClass("myquiz");

					contentHtml += '<table>';
					contentHtml += '<tr>' +
						'<th>Id</th>' +
						'<th>Amount</th>' +
						'<th>start_date</th>' +
						'<th>User</th>' +
						'<th>Questions</th>' +
						'</tr>';
					data.forEach(function(el) {
						contentHtml += '<tr>';
						contentHtml += '<td>'+ el.id +'</td>';
						contentHtml += '<td>'+ el.amount +'</td>';
						contentHtml += '<td>'+ el.start_date +'</td>';
						contentHtml += '<td>';
							contentHtml += '<b>Id:</b> <span>'+el.user.id+'</span><br/>';
							contentHtml += '<b>Name:</b> <span>'+el.user.name+'</span><br/>';
							contentHtml += '<b>Address:</b> <span>'+el.user.address+'</span><br/>';
						contentHtml += '</td>';

						contentHtml += '<td>';
						el.questions.forEach( function (q) {
							contentHtml += '<b>'+ q.question +'</b>';
							//contentHtml += ' ('+ q.category +'; ';
							//contentHtml += ''+ q.difficulty +'; ';
							//contentHtml += ''+ q.type +') ';
							//contentHtml += '<br/><b>'+ q.correct_answer +'</b>';
							contentHtml += ' (';
							q.answers.forEach(function (ia) {
								contentHtml += '<span>'+ia+'</span> | ';
							});
							contentHtml += ') ';
							contentHtml += '<br/><br/>';
						});
						contentHtml += '</td>';

						contentHtml += '</tr>';
					});

					contentHtml += '</table>';
				}

				cont.html(contentHtml);
			},
			error: function error(jqXHR, textStatus, errorThrown) {
				console.log({ "jqXHR": jqXHR, "textStatus": textStatus, "errorThrown": errorThrown });
			}
		});

	});

	// My quiz
	// ============================================================


});



function init() {
}


// getting the sub menu according the chosen top menu
function getSubMenu(topMenu='') {
	let subMenuHtml = '';
	switch (topMenu) {
		case "users":
			subMenuHtml += '<a id="users" href="#">List of users</a> | ';
			subMenuHtml += '<a id="addUserForm" href="#">Add user</a>';
			break;
		case "questions":
			subMenuHtml += '<a id="questions" href="#">List of questions</a>';
			break;
		case "quiz":
			//subMenuHtml += '<a id="quiz" href="#">List of quizzes</a> | ';
			subMenuHtml += '<a id="addQuizForm" href="#">Add quiz</a>';
			break;
		case "tasks":
			subMenuHtml += '<a id="tasks" href="#">List of tasks</a>';
			break;
		case "myquiz":
			//subMenuHtml += '<a id="tasks" href="#">List of users quizzes</a>';
			break;
		default:
			subMenuHtml = '';
	}
	return subMenuHtml;
}

