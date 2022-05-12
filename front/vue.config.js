module.exports = {
    devServer: {
        proxy: {
            '^/meteOwn': {
                target: 'http://localhost:8080'
            }
        }
    }
}