var Sessions = require('../models/sessionModel');

module.exports =function(app){
	app.get('/api/sessions',function(req,res){
		var starterSessions=[
		{
             operation: "today",
             result: "31-08-2020"
		},
		{
             operation: "yesterday",
             result: "30-08-2020"
		}
	   ];
	   Sessions.create(starterSessions,function(err,results){
	   	          res.send(results);
	   });
	});
}