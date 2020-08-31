var Sessions = require('../models/sessionModel');
var bodyParser= require('body-parser');

module.exports= function(app){
	app.use(bodyParser.json());
	app.use(bodyParser.urlencoded({extended:true}));

	app.get('/api/allsessions/:id',function(req,res){
		Sessions.findById({ _id: req.params.id },function(err,sessions){
			if(err) throw err;
			res.send(sessions);

		});

	});
    app.get('/api/allsessions/',function(req,res){
		Sessions.findById({},function(err,sessions){
			
			res.send(sessions);

		});

	});
}