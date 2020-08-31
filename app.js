var express =require('express');
var app=express();
var session=require("express-session");
var DateCalculator  = require("./DateCalculator");
var mongoose=require('mongoose');
var config =require('./config');
var setupcontroller=require('./controllers/setUpcontroller');
var apicontroller=require('./controllers/apiController');
var port =process.env.PORT ||3000;
var bodyParser= require('body-parser');
var Sessions = require('./models/sessionModel');
var mongoStore= require('connect-mongo')(session)


app.use('/assets', express.static(__dirname + '/public'));
app.use(bodyParser.urlencoded({extended: true}))
app.use(bodyParser.json())


app.set('view engine','ejs');

mongoose.connect(config.getDbConnectionString());
app.use(session({
    secret: "date_calculator",
    resave: false,
    saveUninitialized: false,
    store: new mongoStore({mongooseConnection: mongoose.connection})
   }));

app.get("/", (req, res) => {
    console.log(req.session)
    let operations = req.session.operations || [];
    
    req.session.operations = operations;
    return res.render("home", {result: "" || null , operations: req.session.operations})
});
app.post("/", (req, res) => {
    console.log(req.body)
    let calculator = new DateCalculator(req.body.inputDate)
    let result = calculator.operations(req.body.operation, req.body.operationValue);
    let operations = req.session.operations || [];
    let sessionOperation = (req.body.operationValue || '') + " " + req.body.operation + " " + result;
    operations.unshift(sessionOperation);
    req.session.operations = operations;
    // var newSession =new Sessions({
    // 	operation:req.session.operations,
    // 	result:result
    // });
    // newSession.save(function(err){
    // 	res.send('Success');
    // });
    return res.render("home", {result: result || null, operations: req.session.operations})
});

setupcontroller(app);
apicontroller(app);
app.listen(port);