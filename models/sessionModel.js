var mongoose= require('mongoose') ;
var Schema =mongoose.Schema;

var sessionSchema= new Schema({
	operation:String,
	result:String
});

var Sessions=mongoose.model('Sessions',sessionSchema);
module.exports = Sessions;