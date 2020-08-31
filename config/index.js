var configValues = require('./config');


module.exports ={
	getDbConnectionString: function(){
		return 'mongodb+srv://test:'+configValues.pwd+'@cluster0.bjeye.mongodb.net/cluster0?retryWrites=true&w=majority'
	}

} 


