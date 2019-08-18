const { src, dest, parallel}  = require('gulp');
const gulpSass			= require('gulp-sass');
const gulpBrowserify    = require('gulp-browserify');


function sassTask() {
	return  src('./src/main/resources/sass/**/*.scss')
			.pipe(gulpSass( {
	            importer: [
	                function(url, prev, done) {
	                    url = url.startsWith('~') ? url.replace('~', './node_modules/') : url;
	                    done({
	                        file: url   
	                    });
	                }
	            ],
	        }))
			.pipe(dest('./src/main/webapp/css'));
}


function jsTask() {
	return	src('./src/main/resources/js/**/*.js')
			.pipe(gulpBrowserify({}))
			.pipe(dest('./src/main/webapp/js'));
}


function iconsTask() {
    return  src('./node_modules/@fortawesome/fontawesome-free/webfonts/*')
            .pipe(dest('./src/main/webapp/webfonts'));
};

module.exports.default = parallel(sassTask, jsTask, iconsTask);
