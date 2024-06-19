FROM node:lts-alpine

WORKDIR /app

COPY package*.json ./

RUN npm install

# Copy the entire project to the working directory
COPY . .

ENV PORT=8080

EXPOSE 8080

CMD ["npm", "run", "dev"]