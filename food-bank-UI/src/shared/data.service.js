import * as axios from "axios";

const getOrders = async function() {
  try {
    const response = await axios.get(`http://localhost:9090/orders`);

    let data = parseList(response);

    return data;
  } catch (error) {
    console.log(error);
    return [];
  }
};

const getRecipients = async function() {
  try {
    const response = await axios.get(`http://localhost:9090/recipients`);

    let data = parseList(response);

    return data;
  } catch (error) {
    console.log(error);
    return [];
  }
};

const getMany = async function(name) {
  try {
    const response = await axios.get(`http://localhost:9090/${name}`);

    let data = parseList(response);

    return data;
  } catch (error) {
    console.log(error);
    return [];
  }
};

const getOrder = async function(id) {
  try {
    const response = await axios.get(`http://localhost:9090/orders/${id}`);
    let order = parseItem(response, 200);
    return order;
  } catch (error) {
    console.log(error);
    // console.error(error);
    return null;
  }
};

const getSingle = async function(name, id) {
  try {
    const response = await axios.get(`http://localhost:9090/${name}s/${id}`);
    let order = parseItem(response, 200);
    return order;
  } catch (error) {
    console.log(error);
    // console.error(error);
    return null;
  }
};

const updateOrder = async function(order) {
  try {
    const response = await axios.put(
      `http://localhost:9090/orders/${order.id}`,
      order
    );
    const updatedOrder = parseItem(response, 200);
    return updatedOrder;
  } catch (error) {
    console.log(error);
    // console.error(error);
    return null;
  }
};

const createOrder = async function(order) {
  try {
    const response = await axios.post(`http://localhost:9090/orders`, order);
    return response;
  } catch (error) {
    console.log(error);
    return null;
  }
};

const create = async function(name, item) {
  try {
    const response = await axios.post(`http://localhost:9090/${name}`, item);
    return response;
  } catch (error) {
    console.log(error);
    return null;
  }
};

const createRecipient = async function(recipient) {
  try {
    const response = await axios.post(
      `http://localhost:9090/recipients`,
      recipient
    );
    return response;
  } catch (error) {
    console.log(error);
    return null;
  }
};

const deleteOrder = async function(id) {
  try {
    const response = await axios.delete(`http://localhost:9090/orders/${id}`);
    return response;
  } catch (error) {
    console.log(error);
    // console.error(error);
    return null;
  }
};

const parseList = response => {
  if (response.status !== 200) throw Error(response.message);
  if (!response.data) return [];
  let list = response.data;
  if (typeof list !== "object") {
    list = [];
  }
  return list.content;
};

export const parseItem = (response, code) => {
  if (response.status !== code) throw Error(response.message);
  let item = response.data;
  if (typeof item !== "object") {
    item = undefined;
  }
  return item;
};

export const dataService = {
  getOrders,
  getOrder,
  updateOrder,
  deleteOrder,
  createOrder,
  createRecipient,
  getRecipients,
  getSingle,
  getMany,
  create
};
